package com.gaoshin.dragon.exception;

public class InvalidFileException extends BusinessException {
    public InvalidFileException() {
        super(ErrorCode.InvalidInput, "invalid file");
    }

    public InvalidFileException(String msg) {
        super(ErrorCode.InvalidInput, msg);
    }
}
