package com.gs.scm.exception;

public enum ExceptionConstant {

    SQL_EXCEPTION (1001, "Error while database transaction"),
    EMPLOYEE_NOT_FOUND_IN_DB (1002,"Employee not found in Database"),

    INVALID_FIELD(2001,"Invalid Field"),

    INVALID_DATE(3001,"Invalid Date"),
    INVALID_DATE_FORMAT(3002,"Invalid Date Format");

    int errorCode;
    String message;

    ExceptionConstant(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
