package com.abbl.service;

import com.abbl.common.BSRestTemplate;
import com.abbl.crypto.ABBLEncryptor;
import com.abbl.model.requestmodel.PaymentGatewayModelRequest;
import com.abbl.model.requestmodel.gateway.GatewayAccessTokenRequest;
import com.abbl.model.requestmodel.gateway.GatewayPaymentVerifyRequest;
import com.abbl.model.responsemodel.GatewayAccessToken;
import com.abbl.model.responsemodel.GatewayAccessTokenResponse;
import com.abbl.model.responsemodel.PaymentDetailsResponse;
import com.abbl.model.responsemodel.PaymentGatewayModelResponse;
import com.abbl.model.viewmodel.GatewayAccessTokenViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nasir on 12/26/16.
 */
@Service
public class GatewayService {

    //Constant
    private final String BS_URL= "http://localhost:8080";
    private final String WEB_BS_URL= "http://localhost:9090";

    //DI
    @Autowired
    private ABBLEncryptor abblEncryptor;

    public GatewayAccessTokenResponse getGatewayAccessToken(GatewayAccessTokenViewModel gatewayAccessTokenViewModel){
        String requestUrl = BS_URL + "/payment/gateway/access/token";

        GatewayAccessTokenRequest request = getGatewayViewToRequestModel(gatewayAccessTokenViewModel);
        BSRestTemplate<GatewayAccessTokenResponse> restTemplate = new BSRestTemplate<GatewayAccessTokenResponse>();
        return restTemplate.postWithModelWithoutHeader(requestUrl, request, GatewayAccessTokenResponse.class);
    }

    public PaymentDetailsResponse getPaymentDetailsResponse(GatewayPaymentVerifyRequest request){
        String requestUrl = BS_URL + "/payment/verify";

        BSRestTemplate<PaymentDetailsResponse> restTemplate = new BSRestTemplate<PaymentDetailsResponse>();
        return restTemplate.postWithModelWithoutHeader(requestUrl, request, PaymentDetailsResponse.class);
    }

    public GatewayAccessTokenRequest getGatewayViewToRequestModel(GatewayAccessTokenViewModel gatewayAccessTokenViewModel){
        GatewayAccessTokenRequest request = new GatewayAccessTokenRequest();

        request.setUserName(gatewayAccessTokenViewModel.getUserName());
//        request.setPassword(abblEncryptor.encrypt(gatewayAccessTokenViewModel.getPassword()));
        request.setPassword(gatewayAccessTokenViewModel.getPassword());
        return request;
    }

    public void sendPaymentGatewayModelRequest(PaymentGatewayModelRequest paymentGatewayModelRequest){
        String requestUrl = WEB_BS_URL + "/merchant/login";

        PaymentGatewayModelRequest request = new PaymentGatewayModelRequest();
        BSRestTemplate<PaymentGatewayModelResponse> restTemplate = new BSRestTemplate<PaymentGatewayModelResponse>();
        restTemplate.postWithModelWithoutHeader(requestUrl, paymentGatewayModelRequest, PaymentGatewayModelResponse.class);
    }
}
