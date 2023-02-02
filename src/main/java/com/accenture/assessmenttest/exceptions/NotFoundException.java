package com.accenture.assessmenttest.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final String status;
    private final Long code;
    private final List<String> message;
    
    public NotFoundException(Long id) {
        List<String> messages = new ArrayList<>();
        messages.add("Cannot find resource with id " + id);

        this.status = "NOT_FOUND";
        this.code = 30000L;
        this.message = messages;
    }
}
