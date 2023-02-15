package com.ecommance.decaecommance.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

    @NotBlank(message = "name is required")
    private  String name;

    @NotBlank(message = "role is required")
    private String role;

    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "comfirmPassword is required")
    private String comfirmPassword;

    @Min(value = 18, message = "age must be greater than 18")
    private Integer age;
}
