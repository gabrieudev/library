package com.api.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class BusinessRuleException extends LibraryException {

    private String detail;

    public BusinessRuleException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pd.setTitle("Business rule");
        pd.setDetail(detail);

        return pd;

    }

}

