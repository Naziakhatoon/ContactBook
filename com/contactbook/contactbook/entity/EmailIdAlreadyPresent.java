package com.contactbook.contactbook.entity;

public class EmailIdAlreadyPresent extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int errorCode;
    private String errorMessage;

    public EmailIdAlreadyPresent() {
        super();
    }

    public EmailIdAlreadyPresent(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "EmailIdAlreadyPresent{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
