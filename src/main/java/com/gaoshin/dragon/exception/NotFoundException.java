package com.gaoshin.dragon.exception;

public class NotFoundException extends BusinessException {
    public NotFoundException() {
        super(ErrorCode.NotFound);
    }

    public NotFoundException(String msg) {
        super(ErrorCode.NotFound, msg);
    }

}
