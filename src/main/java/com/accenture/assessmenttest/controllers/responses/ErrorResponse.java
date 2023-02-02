package com.accenture.assessmenttest.controllers.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    
    private String status;

    private Long code;

    private List<String> message;
    
}
