package com.ecommance.decaecommance.controller;

import com.ecommance.decaecommance.dto.request.UserRequestDto;
import com.ecommance.decaecommance.dto.response.ApiResponse;
import com.ecommance.decaecommance.dto.response.UserResponseDto;
import com.ecommance.decaecommance.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/users")
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@RequestBody @Valid UserRequestDto request) {
        log.info("Create user call for name: {}", request.getName());
        UserResponseDto response = userService.createUser(request);

        ApiResponse<UserResponseDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(response);
        apiResponse.setMessage("User created successfully");
        apiResponse.setStatus("Success");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);

    }

    @GetMapping(path = "{userId}/user")
    public ResponseEntity<Object> fetchUserById(@PathVariable Long userId) {
        UserResponseDto foundUser = userService.getUserById(userId);

        ApiResponse<UserResponseDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(foundUser);
        apiResponse.setMessage("User fetched successfully");
        apiResponse.setStatus("Success");
        return ResponseEntity.status(200).body(apiResponse);
    }

    @DeleteMapping(path = "{userId}/user")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long userId) {
        userService.deleteUser(userId);

        ApiResponse<UserResponseDto> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("User deleted successfully");
        apiResponse.setStatus("Success");
        return ResponseEntity.status(202).body(apiResponse);
    }

    @PutMapping(path = "{userId}/user")
    public ResponseEntity<Object> updateUserById(@PathVariable Long userId, @RequestBody @Valid UserRequestDto request) {
        UserResponseDto updatedUser = userService.updateUser(userId, request);

        ApiResponse<UserResponseDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(updatedUser);
        apiResponse.setMessage("User updated successfully");
        apiResponse.setStatus("Success");
        return ResponseEntity.status(200).body(apiResponse);
    }

}
