package com.loginAssessment.service.impl;

import com.loginAssessment.dto.UserDto;
import com.loginAssessment.entity.UserEntity;
import com.loginAssessment.mapper.UserMapper;
import com.loginAssessment.repo.UserRepo;
import com.loginAssessment.request.LoginRequest;
import com.loginAssessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BCryptPasswordEncoder encoder;
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepository) {
        this.userRepo = userRepository;
    }

    @Override
    public UserDto uerSignUp(UserDto userDto) {
        userDto.setPassword(encoder.encode(userDto.getPassword()));
        UserEntity userEntity = UserMapper.mapToUserEntity(userDto);
        UserEntity saveUserEntity = userRepo.save(userEntity);
        return UserMapper.mapToUserDto(saveUserEntity);

    }

    @Override
    public boolean uerLogin(LoginRequest loginRequest) {
        UserEntity loginEntity = userRepo.findByUserId(loginRequest.getUserId());
        if (userRepo.findByUserId(loginRequest.getUserId()) != null) {
            boolean isValid = encoder.matches(loginRequest.getPassword(), loginEntity.getPassword());
            return isValid;
        }
        return false;
    }
}
