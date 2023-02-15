package com.ecommance.decaecommance.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserResponseDto {

    private String name;

    private String role;

    private Integer age;
}
