package com.abbl.common;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mizan on 4/11/2014.
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BaseModel {
    private int responseCode;
    private List<String> errors;

    public BaseModel(){
        errors = new ArrayList<String>();
    }

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
