package com.gaoshin.dragon.exception;

public class InvalidStatusException extends BusinessException {
    public InvalidStatusException() {
        super(ErrorCode.InvalidStatus);
    }

    public InvalidStatusException(String msg) {
        super(ErrorCode.InvalidStatus, msg);
    }
}
