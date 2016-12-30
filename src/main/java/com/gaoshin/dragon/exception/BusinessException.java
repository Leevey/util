package com.gaoshin.dragon.exception;

public class BusinessException extends RuntimeException {
    private ErrorCode errorCode;

    public BusinessException() {
        super();
    }

    public BusinessException(ErrorCode errorCode) {
        this.setErrorCode(errorCode);
    }

    public BusinessException(ErrorCode errorCode, Throwable t) {
        super(t);
        this.setErrorCode(errorCode);
    }

    public BusinessException(ErrorCode errorCode, String msg) {
        super(msg);
        this.setErrorCode(errorCode);
    }

    public BusinessException(ErrorCode errorCode, String msg, Throwable t) {
        super(msg, t);
        this.setErrorCode(errorCode);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
