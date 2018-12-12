package com.abbl.model.requestmodel.gateway;

/**
 * Created by nasir on 12/22/16.
 */
public class GatewayPaymentVerifyRequest {
    private String merchantKey;
    private String sslReferenceId;
    private String password;

    public String getMerchantKey() {
        return merchantKey.trim();
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getSslReferenceId() {
        return sslReferenceId;
    }

    public void setSslReferenceId(String sslReferenceId) {
        this.sslReferenceId = sslReferenceId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
