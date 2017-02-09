package com.abbl.model.responsemodel;

import com.abbl.common.BaseModel;
import com.abbl.model.requestmodel.PaymentDetails;

/**
 * Created by nasir on 12/27/16.
 */
public class PaymentDetailsResponse extends BaseModel{
    private PaymentDetails items;

    public PaymentDetails getItems() {
        return items;
    }

    public void setItems(PaymentDetails items) {
        this.items = items;
    }
}
