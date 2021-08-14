package com.ustc.template.controller;

import com.ustc.template.common.Response;
import com.ustc.template.exception.InvalidRequestException;
import com.ustc.template.model.User;
import com.ustc.template.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.NotFoundException;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public @ResponseBody
    String addUser(@RequestParam(defaultValue = "zhaotx") String name) {
        User user = new User();
        user.setUserName(name);
        userRepository.save(user);
        return Response.ok();
    }

    @GetMapping("/list")
    public @ResponseBody
    String listUser() {
        return Response.ok(userRepository.findAll());
    }

    @GetMapping("/get")
    public @ResponseBody
    String getUserById(@RequestParam("id") int id) {
        if (id <= 0) {
            throw new InvalidRequestException("User id is low 0");
        }
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("User is not found");
        }
        return Response.ok(optionalUser.get());
    }
}
