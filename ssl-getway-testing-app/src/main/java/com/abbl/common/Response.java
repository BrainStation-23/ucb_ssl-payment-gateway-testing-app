package com.abbl.common;

/**
 * Created by nasir on 6/3/2014.
 */
public class Response<T> extends BaseResponse {
    private T items;

    public T getItems() {
        return items;
}

    public void setItems(T items) {
        this.items = items;
    }
}
