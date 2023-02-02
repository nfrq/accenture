package com.accenture.assessmenttest.controllers.responses;

import java.util.List;

import com.accenture.assessmenttest.serializations.UserSerialization;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationResponse {
    
    private List<UserSerialization> userData;

    private Integer maxRecords;
    
    private Integer offset;

}
