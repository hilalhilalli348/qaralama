package com.example.workflow.dto;

import java.io.Serializable;

public class CommonResponse<E> implements Serializable {

    private Status status;
    private E data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
