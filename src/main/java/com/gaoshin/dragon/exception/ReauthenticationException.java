package com.gaoshin.dragon.exception;

public class ReauthenticationException extends BusinessException {
    public ReauthenticationException() {
        super(ErrorCode.ReauthenticationError);
    }

    public ReauthenticationException(String msg) {
        super(ErrorCode.ReauthenticationError, msg);
    }
}
