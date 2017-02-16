package com.abbl.model.requestmodel;

/**
 * Created by nasir on 12/22/16.
 */
public class PaymentDetails {
    private int statusCode;
    private String accountHolderName;
    private String transactionReference;
    private String SSLRefId;
    private double paidAmount;
    private String errorReason;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
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

    public String getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "statusCode=" + statusCode +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", transactionReference='" + transactionReference + '\'' +
                ", SSLRefId='" + SSLRefId + '\'' +
                ", paidAmount=" + paidAmount +
                ", errorReason='" + errorReason + '\'' +
                '}';
    }
}
