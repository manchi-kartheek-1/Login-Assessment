package com.loginAssessment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class UserDto {
    private Integer id;
    @NotNull(message = "The userId is mandatory.")
    private Long userId;
    @NotBlank(message = "The password is mandatory.")
    private String password;
}
