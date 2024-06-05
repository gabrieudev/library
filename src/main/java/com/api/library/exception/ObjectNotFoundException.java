package com.api.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ObjectNotFoundException extends LibraryException {

    private String detail;

    public ObjectNotFoundException(String detail) {
        this.detail = detail;
    }

    public ObjectNotFoundException(String detail, Throwable cause) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pd.setTitle("Object not found");
        pd.setDetail(detail);

        return pd;

    }

}
