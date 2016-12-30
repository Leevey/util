package com.gaoshin.dragon.exception;

public class NoEnoughFundException extends BusinessException {
    public NoEnoughFundException() {
        super(ErrorCode.NoEnoughFund);
    }

    public NoEnoughFundException(String msg) {
        super(ErrorCode.NoEnoughFund, msg);
    }

}
