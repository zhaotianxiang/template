package com.ustc.template.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {
    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "用户名不能为空")
    private String name;
}
