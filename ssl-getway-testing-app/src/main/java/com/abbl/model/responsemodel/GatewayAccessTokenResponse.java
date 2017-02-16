package com.abbl.model.responsemodel;

import com.abbl.common.BaseModel;

/**
 * Created by bs057 on 12/26/16.
 */
public class GatewayAccessTokenResponse extends BaseModel {

    public GatewayAccessToken items;

    public GatewayAccessToken getItems() {
        return items;
    }

    public void setItems(GatewayAccessToken items) {
        this.items = items;
    }
}
