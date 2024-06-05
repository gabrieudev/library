package com.api.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UserAlreadyExistsException extends LibraryException {

    private String detail;

    public UserAlreadyExistsException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pd.setTitle("User already exists");
        pd.setDetail(detail);

        return pd;

    }
}
