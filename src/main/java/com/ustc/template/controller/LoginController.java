package com.ustc.template.controller;

import com.ustc.template.common.Response;
import com.ustc.template.dto.LoginForm;
import com.ustc.template.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoginController {

    @PostMapping("/login")
    public @ResponseBody String addUser(@Valid @RequestBody LoginForm loginForm) {

        return Response.ok(loginForm);
    }
}
