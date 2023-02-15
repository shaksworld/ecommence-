package com.ecommance.decaecommance.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private String message;

    private String status;

    private T data;

    private final LocalDateTime time = LocalDateTime.now();
}
