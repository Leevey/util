package com.gaoshin.dragon.exception;

public class FileStoreException extends BusinessException {
	public FileStoreException() {
		super(ErrorCode.FileStoreError);
	}
	public FileStoreException(Throwable t) {
		super(ErrorCode.FileStoreError, t);
	}
	public FileStoreException(String msg) {
		super(ErrorCode.FileStoreError,msg);
	}
}
