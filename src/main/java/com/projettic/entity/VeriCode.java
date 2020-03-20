package com.projettic.entity;

public enum VeriCode {
    /**
     * Correct
     */
    CORRECT(1001, "Correct"),

    /**
     * Didn't find correction in DB, but the result is correct
     */
    UNDETERMINED(1002, "Didn't find correction in DB, but the result is correct"),

    /**
     * Didn't find correction in DB, and the result is not correct
     */
    FAULT(1003, "Didn't find correction in DB, and the result is not correct");


    private int code;
    private String message;

    VeriCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

