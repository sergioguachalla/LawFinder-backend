package com.lawfinder.backend.dto;

public class ResponseDto<T> {
    private Integer code;
    private T data;
    private String message;

    public ResponseDto() {}

    public ResponseDto(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    //getters

    public Integer getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    //setters

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
