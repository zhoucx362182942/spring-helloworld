package com.zcx.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Data
@ToString
public class User {
    @NotBlank(message = "name can not null")
    private String name;

    private String age;

    private String sex;


}
