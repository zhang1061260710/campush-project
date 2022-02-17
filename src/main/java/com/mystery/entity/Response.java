package com.mystery.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Response implements Serializable {
    private int Code;
    private String Message;
    private Object Data;

    public Response() {
    }

    public Response(int code, String message, Object data) {
        Code = code;
        Message = message;
        Data = data;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public static Response OK(Object data){
        return new Response(1,"success",data);
    }

    public static Response Error(){
        return new Response(0,"failed",null);
    }

    @Override
    public String toString() {
        return "{" +
                "Code=" + Code +
                ", Message='" + Message + '\'' +
                ", Data=" + Data +
                '}';
    }
}
