package com.ustc.template.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ustc.template.constant.ReturnCode;
import com.ustc.template.model.User;
import com.ustc.template.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private UserRepository userRepository;

    User user1 = new User(1, "zhaotx");
    User user2 = new User(2, "tianx");
    User user3 = new User(3, "xxxx");

    @Test
    void addUser_success() throws Exception {
        Mockito.when(userRepository.save(user1)).thenReturn(user1);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(user1));

        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.code", is(ReturnCode.SUCCESS)));
    }

    @Test
    void addUser_error() {

    }

    @Test
    void listUser() {
    }

    @Test
    void getUserById() {
    }
}