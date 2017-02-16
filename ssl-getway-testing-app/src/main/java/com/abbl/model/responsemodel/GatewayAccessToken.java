package com.abbl.model.responsemodel;

/**
 * Created by nasir on 12/21/16.
 */
public class GatewayAccessToken{
    private String merchantKey;

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    @Override
    public String toString() {
        return "GatewayAccessToken{" +
                "merchantKey='" + merchantKey + '\'' +
                '}';
    }
}
