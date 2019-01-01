package com.zcx.controller.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class RestResponse<T> implements Serializable {
    private Boolean success = false;
    private String code;
    private String message;
    private T obj;
    private String returnUrl;
}
