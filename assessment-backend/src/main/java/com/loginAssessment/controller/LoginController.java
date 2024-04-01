package com.loginAssessment.controller;


import com.loginAssessment.dto.UserDto;
import com.loginAssessment.repo.UserRepo;
import com.loginAssessment.request.LoginRequest;
import com.loginAssessment.response.LoginResponse;
import com.loginAssessment.service.UserService;
import com.loginAssessment.validator.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    JwtUtil jwtUtil;
    private final UserService userService;
    private final UserRepo userRepo;

    @Autowired
    public LoginController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @PostMapping("/userSignUp")
    public ResponseEntity<?> userSignUp(@RequestBody UserDto userDto) {
        if (userRepo.findByUserId(userDto.getUserId()) == null) {
            UserDto sighUpAdmin = userService.uerSignUp(userDto);
            return new ResponseEntity<>(sighUpAdmin, HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Userid already Exists..!!");
        }
    }

    @PostMapping("/userLogIn")
    public ResponseEntity<?> userLogin(@RequestBody LoginRequest loginRequest) {
        if (userService.uerLogin(loginRequest)) {
            String token = jwtUtil.generateToken(loginRequest.getUserId().toString());
            return ResponseEntity.ok(new LoginResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid userId or password");
        }
    }
}
