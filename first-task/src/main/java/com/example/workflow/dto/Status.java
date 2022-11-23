package com.example.workflow.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class Status implements Serializable {
    private int statusCode;
    private String message;

    public static Status successStatus() {
        return new Status(1, "process success compiled");
    }

    public Status() {
    }

    public Status(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
