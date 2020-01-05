package com.abbl.model.requestmodel;

import java.io.Serializable;

/**
 * Created by nasir on 12/27/16.
 */
public class PaymentGatewayReturnRequest implements Serializable {
    private String transactionID;
    private String statusCode;
    private String SSLRefId;
    private double paidAmount;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getSSLRefId() {
        return SSLRefId;
    }

    public void setSSLRefId(String SSLRefId) {
        this.SSLRefId = SSLRefId;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    @Override
    public String toString() {
        return "PaymentGatewayReturnRequest{" +
                "transactionID='" + transactionID + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", SSLRefId='" + SSLRefId + '\'' +
                ", paidAmount=" + paidAmount +
                '}';
    }
}
