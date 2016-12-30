package com.gaoshin.dragon.exception;

public class InvalidRequestException extends BusinessException {
    public InvalidRequestException() {
        super(ErrorCode.InvalidInput);
    }

    public InvalidRequestException(String msg) {
        super(ErrorCode.InvalidInput, msg);
    }

}
