package com.abbl.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nasir on 4/13/2014.
 */
public class BaseResponse {
    public BaseResponse() {
        this.errors = new ArrayList<String>();
    }

    private int responseCode;

    private List<String> errors;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
