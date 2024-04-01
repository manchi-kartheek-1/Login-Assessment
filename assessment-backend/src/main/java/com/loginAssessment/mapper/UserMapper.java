package com.loginAssessment.mapper;

import com.loginAssessment.dto.UserDto;
import com.loginAssessment.entity.UserEntity;

public class UserMapper {
    public static UserDto mapToUserDto(UserEntity userEntity) {
        return new UserDto(userEntity.getId(), userEntity.getUserId(), userEntity.getPassword());
    }

    public static UserEntity mapToUserEntity(UserDto userDto) {
        return new UserEntity(userDto.getId(), userDto.getUserId(), userDto.getPassword());
    }
}
