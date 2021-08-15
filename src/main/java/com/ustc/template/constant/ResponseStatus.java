package com.ustc.template.constant;

import lombok.Data;

public enum ResponseStatus {
    OK(0,"OK"),
    PARAM_MISSING(1,"PARAM MISSING"),
    ;

    private int code;
    private String message;

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
