package com.gaoshin.dragon.exception;

public class SmsException extends BusinessException {
    public SmsException() {
        super(ErrorCode.SmsError);
    }

    public SmsException(Throwable t) {
        super(ErrorCode.SmsError, t);
    }

    public SmsException(String msg) {
        super(ErrorCode.SmsError, msg);
    }
}
