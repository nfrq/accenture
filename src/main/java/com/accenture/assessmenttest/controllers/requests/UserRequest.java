package com.accenture.assessmenttest.controllers.requests;

import java.time.LocalDate;

import com.accenture.assessmenttest.validations.ValidDateFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    
    @NotBlank(message = "ssn is mandatory")
    private String ssn;

    @NotBlank(message = "first_name is mandatory")
    private String firstName;

    private String lastName;

    private LocalDate birthDate;

}
