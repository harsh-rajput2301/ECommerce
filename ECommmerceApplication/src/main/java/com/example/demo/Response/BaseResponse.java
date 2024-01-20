package com.example.demo.Response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {
    private T body;
    private Integer resultCode;
    private String status;
}
