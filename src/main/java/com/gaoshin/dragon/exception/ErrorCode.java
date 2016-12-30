package com.gaoshin.dragon.exception;

public enum ErrorCode {
    Unknown(500),

    /**
     * Invalid input error such as missing required field. Status code 450.
     */
    InvalidInput(450),

    /**
     * Invalid password. Status code 451
     */
    InvalidPassword(451),

    /**
     * Duplicated error which means same unique object exists already. 
     * Status code 452.
     */
    Duplicated(452),

    /**
     * User must login first. Status code 453.
     */
    NoGuest(453),

    /**
     * Permission denied. Status code 454.
     */
    PermissionDenied(454),

    /**
     * Requested object not found. Status code 455.
     */
    NotFound(455),

    /**
     * FileStore issue status code 456
     */
    FileStoreError(456),

    /**
     * Invalid status. Status code 458
     */
    InvalidStatus(458),

    /**
     * Invalid json. Status code 460.
     */
    InvalidJson(460),

    /**
     * Invalid ID. Status code 461.
     */
    InvalidId(461),

    /**
     * Sms error
     */
    SmsError(462),
    
    SearchError(468),

    /**
     * Sms error
     */
    ReauthenticationError(463),

    InvalidValidationCode(464),

    NoEnoughFund(480),

    NetworkException(499),

    ;

    private int code;

    private ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
