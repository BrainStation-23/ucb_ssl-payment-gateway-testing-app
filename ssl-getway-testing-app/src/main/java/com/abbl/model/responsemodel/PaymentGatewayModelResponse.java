package com.abbl.model.responsemodel;

import com.abbl.common.BaseModel;

/**
 * Created by nasir on 12/26/16.
 */
public class PaymentGatewayModelResponse extends BaseModel{
    private PaymentGatewayModel items;

    public PaymentGatewayModel getItems() {
        return items;
    }

    public void setItems(PaymentGatewayModel items) {
        this.items = items;
    }
}
