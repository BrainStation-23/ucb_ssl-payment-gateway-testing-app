package com.abbl.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nasir on 4/13/2014.
 */
public class BaseResponse {
    private int responseCode;
    private List<String> responseMessages;

    public BaseResponse() {
        this.responseMessages = new ArrayList<String>();
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<String> getResponseMessages() {
        return responseMessages;
    }

    public void setResponseMessages(List<String> responseMessages) {
        this.responseMessages = responseMessages;
    }
}
