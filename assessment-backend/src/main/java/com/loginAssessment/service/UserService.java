package com.loginAssessment.service;

import com.loginAssessment.dto.UserDto;
import com.loginAssessment.request.LoginRequest;

public interface UserService {
    public UserDto uerSignUp(UserDto userDto);

    public boolean uerLogin(LoginRequest loginRequest);

}
