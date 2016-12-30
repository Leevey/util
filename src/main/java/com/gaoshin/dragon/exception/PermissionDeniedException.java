package com.gaoshin.dragon.exception;

public class PermissionDeniedException extends BusinessException {
    public PermissionDeniedException() {
        super(ErrorCode.PermissionDenied);
    }

    public PermissionDeniedException(String msg) {
        super(ErrorCode.PermissionDenied, msg);
    }
}
