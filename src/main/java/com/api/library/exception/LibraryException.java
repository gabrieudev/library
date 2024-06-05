package com.api.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class LibraryException extends RuntimeException {

    public ProblemDetail toProblemDetail() {

        var pd = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pd.setTitle("Library internal server error");

        return pd;

    }

}
