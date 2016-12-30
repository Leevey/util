package com.gaoshin.dragon.exception;

public class SearchException extends BusinessException {
    public SearchException(String msg) {
        super(ErrorCode.SearchError, msg);
    }

    public SearchException(Throwable t) {
        super(ErrorCode.SearchError, t);
    }

    public SearchException(String msg, Throwable t) {
        super(ErrorCode.SearchError, msg, t);
    }
}
