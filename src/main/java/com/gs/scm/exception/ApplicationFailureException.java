package com.gs.scm.exception;

public class ApplicationFailureException extends Exception {

    ExceptionConstant exceptionConstant;

    public ApplicationFailureException() {
        super();
    }

    public ApplicationFailureException(String message) {
        super(message);
    }

    public ApplicationFailureException(ExceptionConstant exceptionConstant) {
        this.exceptionConstant = exceptionConstant;
    }

    public ExceptionConstant getExceptionConstant() {
        return exceptionConstant;
    }

    public void setExceptionConstant(ExceptionConstant exceptionConstant) {
        this.exceptionConstant = exceptionConstant;
    }
}
