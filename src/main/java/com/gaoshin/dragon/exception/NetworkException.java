package com.gaoshin.dragon.exception;

public class NetworkException extends BusinessException {
    public NetworkException() {
        super(ErrorCode.NetworkException);
    }

    public NetworkException(Throwable t) {
        super(ErrorCode.NetworkException, t);
    }

    public NetworkException(String msg) {
        super(ErrorCode.NetworkException, msg);
    }
}
