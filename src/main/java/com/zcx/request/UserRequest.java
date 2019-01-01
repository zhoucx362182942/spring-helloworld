package com.zcx.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRequest {
    private String name;
    private String age;
    private String sex;
}
