package com.gaoshin.dragon.exception;

public class InvalidPasswordException extends BusinessException {
    public InvalidPasswordException() {
        super(ErrorCode.InvalidPassword);
    }
}
