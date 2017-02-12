package com.abbl.controller;

import com.abbl.model.requestmodel.PaymentGatewayModelRequest;
import com.abbl.model.requestmodel.PaymentGatewayReturnRequest;
import com.abbl.model.requestmodel.gateway.GatewayPaymentVerifyRequest;
import com.abbl.model.responsemodel.GatewayAccessTokenResponse;
import com.abbl.model.responsemodel.PaymentDetailsResponse;
import com.abbl.model.viewmodel.GatewayAccessTokenViewModel;
import com.abbl.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by nasir on 12/22/16.
 */
@Controller
public class HomeController {

    @Autowired
    private GatewayService gatewayService;

    private String status;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(Model model, HttpSession session){
        model.addAttribute("gatewayDto", new GatewayAccessTokenViewModel());
        session.setAttribute("merchantKey", null);
        if(session.getAttribute("statusList")==null){
            session.setAttribute("statusList", "Status Starts... | at: " + new Date());
        }
        List<String> statusListRight = getStatusList("" + session.getAttribute("statusList"));
        model.addAttribute("statusListRight", statusListRight);
        return "home";
    }

    @RequestMapping(value = "/{reset}", method = RequestMethod.GET)
    public String homeReset(@PathVariable("reset") boolean reset, Model model, HttpSession session){
        model.addAttribute("gatewayDto", new GatewayAccessTokenViewModel());
        if(reset){
            session.setAttribute("merchantKey", null);
            session.setAttribute("statusList", "Status Starts... | at: " + new Date());
        }
        List<String> statusListRight = getStatusList("" + session.getAttribute("statusList"));
        model.addAttribute("statusListRight", statusListRight);
        return "home";
    }

    @RequestMapping(value = "/gateway/token", method = RequestMethod.POST)
    public String getResponseGatewayAccessToken(Model model, @ModelAttribute("gatewayDto") GatewayAccessTokenViewModel gatewayAccessTokenViewModel, HttpSession session){

        GatewayAccessTokenResponse gatewayAccessTokenResponse = gatewayService.getGatewayAccessToken(gatewayAccessTokenViewModel);

        if(gatewayAccessTokenResponse.getItems() != null) {

            status = "Successfully get Merchant Key!";
            session.setAttribute("merchantKey", gatewayAccessTokenResponse.getItems().getMerchantKey());
            PaymentGatewayModelRequest paymentGatewayModelRequest = new PaymentGatewayModelRequest();
            paymentGatewayModelRequest.setProductName("Rice");
            paymentGatewayModelRequest.setProductPrice(1);
            paymentGatewayModelRequest.setSSLRefId("AB00001010");
            paymentGatewayModelRequest.setMerchantName("My Merchant");
            paymentGatewayModelRequest.setMerchantKey(gatewayAccessTokenResponse.getItems().getMerchantKey());
            paymentGatewayModelRequest.setReturnURL("localhost:7080/return/payment/gateway");
            model.addAttribute("paymentGatewayModelRequest", paymentGatewayModelRequest);
            model.addAttribute("status", status);
            model.addAttribute("responseBody", gatewayAccessTokenResponse.getItems().toString());
            model.addAttribute("requestBody", gatewayAccessTokenViewModel.toString());
        } else {
            session.setAttribute("merchantKey", null);
            status = "Failed to get Merchant Key!";
        }

        int i=0;
        for(String str : gatewayAccessTokenResponse.getErrors()){
            status = status + "<br>err "+(++i)+":"+str;
        }

        session = addAndGetSession(session, status);

        List<String> statusListRight = getStatusList("" + session.getAttribute("statusList"));
        model.addAttribute("statusListRight", statusListRight);
        model.addAttribute("gatewayDto", gatewayAccessTokenViewModel);
        return "home";
    }

    @RequestMapping(value = "/send/payment/gateway", method = RequestMethod.POST)
    public String sendPaymentGatewayModelRequest(Model model, @ModelAttribute("paymentGatewayModelRequest") PaymentGatewayModelRequest paymentGatewayModelRequest, HttpSession session){

        model.addAttribute("paymentGatewayModelRequest", paymentGatewayModelRequest);

        model.addAttribute("gatewayDto", new GatewayAccessTokenViewModel());

        gatewayService.sendPaymentGatewayModelRequest(paymentGatewayModelRequest);

        return "home";
    }

    @RequestMapping(value = "/return/payment/gateway", method = RequestMethod.GET)
    public String getPaymentGatewayFinishedResponse(@ModelAttribute PaymentGatewayReturnRequest request, Model model, HttpSession session){
        if(request == null){
            status = "Failed to get Payment complete request!";
        } else {

            status = "Successfully get Payment complete request!";
            model.addAttribute("requestBody", request.toString());

            GatewayPaymentVerifyRequest gatewayPaymentVerifyRequest = new GatewayPaymentVerifyRequest();
            gatewayPaymentVerifyRequest.setMerchantKey("" + session.getAttribute("merchantKey"));
            gatewayPaymentVerifyRequest.setTransactionReference(request.getTransactionID());
            model.addAttribute("status", status);

            model.addAttribute("gatewayPaymentVerifyRequest", gatewayPaymentVerifyRequest);
        }

        session = addAndGetSession(session, status);

        List<String> statusListRight = getStatusList("" + session.getAttribute("statusList"));
        model.addAttribute("statusListRight", statusListRight);
        model.addAttribute("gatewayDto", new GatewayAccessTokenViewModel());

        return "home";

    }
    @RequestMapping(value = "/return/payment/gateway", method = RequestMethod.POST)
    public String postPaymentGatewayFinishedResponse(@ModelAttribute("gatewayPaymentVerifyRequest") GatewayPaymentVerifyRequest gatewayPaymentVerifyRequest, Model model, HttpSession session){

        PaymentDetailsResponse paymentDetailsResponse = gatewayService.getPaymentDetailsResponse(gatewayPaymentVerifyRequest);

        if(paymentDetailsResponse.getItems() != null) {
            status = "Successfully get Payment Details!";

            model.addAttribute("status", status);
            model.addAttribute("responseBody", paymentDetailsResponse.getItems().toString());
            model.addAttribute("requestBody", paymentDetailsResponse.toString());
        } else {
            status = "Failed to get Merchant Key!";
        }

        int i=0;
        for(String str : paymentDetailsResponse.getErrors()){
            status = status + "<br>err "+(++i)+":"+str;
        }

        session = addAndGetSession(session, status);

        List<String> statusListRight = getStatusList("" + session.getAttribute("statusList"));
        model.addAttribute("statusListRight", statusListRight);
        model.addAttribute("gatewayDto", new GatewayAccessTokenViewModel());
        return "home";

    }

    public HttpSession addAndGetSession(HttpSession session, String newStatus){
        String preStatus = "" + session.getAttribute("statusList");
        session.setAttribute("statusList", preStatus + "-" + newStatus + " | at: " +new Date());
        return session;
    }

    public List<String> getStatusList(String str){
        String[] strArray = str.split("-");
        List<String> statusList = Arrays.asList(strArray);
        Collections.reverse(statusList);
        return statusList;
    }
}
