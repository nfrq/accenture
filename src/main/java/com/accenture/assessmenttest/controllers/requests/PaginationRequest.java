package com.accenture.assessmenttest.controllers.requests;

import lombok.Data;

@Data
public class PaginationRequest {

    private Integer maxRecords = 5;

    private Integer offset = 0;

}
