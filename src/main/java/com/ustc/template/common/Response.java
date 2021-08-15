package com.ustc.template.common;

import com.alibaba.fastjson.JSON;
import com.ustc.template.constant.ResponseStatus;
import lombok.Data;

import java.util.Date;

@Data
public class Response {
    private int code;
    private String message;
    private Object data;

    public static String ok() {
        Response response = new Response();
        response.code = 0;
        response.message = "success";
        return JSON.toJSONString(response);
    }

    public static String ok(Object data) {
        Response response = new Response();
        response.code = 0;
        response.message = "success";
        response.data = data;
        return JSON.toJSONString(response);
    }

    public static Object error(int code, String message) {
        Response response = new Response();
        response.code = code;
        response.message = message;
        return response;
    }
}
