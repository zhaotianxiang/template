package com.ustc.template.interceptor;

import com.ustc.template.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.nio.file.spi.FileSystemProvider;



import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CustomRestExceptionHandlerTest {
    @Mock
    private RestTemplate restTemplate;

    @Test
    void handleMethodArgumentNotValid() {
    }

    @Test
    void handleMissingServletRequestParameter() {
    }

    @Test
    void handleConstraintViolation() {
    }

    @Test
    void handleMethodArgumentTypeMismatch() {
    }

    @Test
    void handleNoHandlerFoundException() {
        User user = new User();
        Mockito.when(
                restTemplate.getForEntity("127.0.0.1:8080/get?id=1", User.class))
                .thenReturn(new ResponseEntity<>(user, HttpStatus.OK));
    }

}