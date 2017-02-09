package com.abbl.model.requestmodel.gateway;

/**
 * Created by nasir on 12/22/16.
 */
public class GatewayPaymentVerifyRequest {
    private String merchantKey;
    private String transactionReference;
    private String password;

    public String getMerchantKey() {
        return merchantKey.trim();
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
