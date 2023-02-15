package com.ecommance.decaecommance.service;

import com.ecommance.decaecommance.dto.request.UserRequestDto;
import com.ecommance.decaecommance.dto.response.UserResponseDto;

public interface UserService {

     UserResponseDto createUser(UserRequestDto request);

     UserResponseDto getUserById(Long userId);

     UserResponseDto updateUser(Long userId, UserRequestDto request);

     void deleteUser(Long userId);
}
