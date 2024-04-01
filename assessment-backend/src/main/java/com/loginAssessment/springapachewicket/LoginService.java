/*
package com.loginAssessment.loginAssessment.service;

import com.loginAssessment.loginAssessment.dto.UserDto;
import com.loginAssessment.loginAssessment.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
    private final RestTemplate restTemplate;

    public LoginService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> userSignUp(UserDto userDto) {
        return restTemplate.postForEntity("http://localhost:8080/api/userSignUp", userDto, ResponseEntity.class);
    }

    public ResponseEntity<?> userLogin(LoginRequest loginRequest) {
        return restTemplate.postForEntity("http://localhost:8080/api/userLogIn", loginRequest, ResponseEntity.class);
    }
}
*/
