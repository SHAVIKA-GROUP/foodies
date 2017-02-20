package com.shavika.foodies.api.exception;

public class ShavikaAppException extends ShavikaException {
	
	private static final long serialVersionUID = 6862235244823818174L;

	public ShavikaAppException() {
	}

	public ShavikaAppException(String strErrorCode) {
		super(strErrorCode);
	}

	public ShavikaAppException(String strErrorCode, Throwable cause) {
		super(strErrorCode, cause);
	}

	public ShavikaAppException(String strErrorMsg, String strErrorCode, Throwable cause) {
		super(strErrorMsg, strErrorCode, cause);
	}
}
