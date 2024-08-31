package com.hrdku.user.dto;

import java.util.ArrayList;
import java.util.List;

import com.hrdku.user.users.Users;

public class ResponseData<T> {
    private boolean result;
    private List<String> message = new ArrayList<>();
    private List<Users> data;

    public ResponseData() {
        super();
    }

    public ResponseData(boolean result, List<String> message, List<Users> data) {
        super();
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public List<Users> getData() {
        return data;
    }

    public void setData(List<Users> value) {
        this.data = value;
    }
}
