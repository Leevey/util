package com.gaoshin.dragon.exception;

public class NoGuestException extends BusinessException {
    public NoGuestException() {
        super(ErrorCode.NoGuest);
    }
}
