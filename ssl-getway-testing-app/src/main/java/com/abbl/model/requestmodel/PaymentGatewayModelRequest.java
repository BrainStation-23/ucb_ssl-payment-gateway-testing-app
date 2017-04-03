package com.abbl.model.requestmodel;

/**
 * Created by nasir on 12/26/16.
 */
public class PaymentGatewayModelRequest {

    private String merchantKey;
    private String productName;
    private double productPrice;
    private String SSLRefId;
    private String returnURL;
    private String merchantName;
    private String merchantIMG_url;
    private String merchantIPAddress;

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getSSLRefId() {
        return SSLRefId;
    }

    public void setSSLRefId(String SSLRefId) {
        this.SSLRefId = SSLRefId;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantIMG_url() {
        return merchantIMG_url;
    }

    public void setMerchantIMG_url(String merchantIMG_url) {
        this.merchantIMG_url = merchantIMG_url;
    }

    public String getMerchantIPAddress() {
        return merchantIPAddress;
    }

    public void setMerchantIPAddress(String merchantIPAddress) {
        this.merchantIPAddress = merchantIPAddress;
    }
}
