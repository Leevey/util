package com.gaoshin.dragon.exception;

public class DuplicatedException extends BusinessException {
    public DuplicatedException() {
        super(ErrorCode.Duplicated);
    }

    public DuplicatedException(String msg) {
        super(ErrorCode.Duplicated, msg);
    }
}
