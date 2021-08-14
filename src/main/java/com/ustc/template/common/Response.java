package com.ustc.template.common;

import com.google.gson.Gson;
import lombok.Data;

import java.util.Date;

@Data
public class Response {
    private int code;
    private String message;
    private Date date;
    private Object data;

    public static String ok(){
        Response response = new Response();
        response.code = 0;
        response.message = "success";
        response.date = new Date();
        return new Gson().toJson(response);
    }

    public static String ok(Object data){
        Response response = new Response();
        response.code = 0;
        response.message = "success";
        response.date = new Date();
        return new Gson().toJson(response);
    }
}
