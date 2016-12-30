package com.gaoshin.dragon.exception;

public class InvalidValidationCodeException extends BusinessException {
    public InvalidValidationCodeException() {
        super(ErrorCode.InvalidValidationCode);
    }

    public InvalidValidationCodeException(String msg) {
        super(ErrorCode.InvalidValidationCode, msg);
    }

}
