package com.gaoshin.dragon.exception;

public class IgnorableException extends Exception {
    public IgnorableException() {}

    public IgnorableException(String msg) {
        super(msg);
    }

    public IgnorableException(Throwable t) {
        super(t);
    }

    public IgnorableException(Throwable t, String msg) {
        super(msg, t);
    }
}
