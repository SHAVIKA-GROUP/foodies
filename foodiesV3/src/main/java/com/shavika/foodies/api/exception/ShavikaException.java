package com.shavika.foodies.api.exception;

public abstract class ShavikaException extends Exception {

	private String errorCode;
	private ErrorMsgLoader errorMsgLoader = new ErrorMsgLoader();

	public ShavikaException() {
	}

	public ShavikaException(String errCode) {
		this.errorCode = errCode;
	}

	public ShavikaException(String errCode, Throwable cause) {
		super(cause);
		this.errorCode = errCode;
	}

	public ShavikaException(String strErrorMsg, String errCode, Throwable cause) {
		super(strErrorMsg, cause);
		this.errorCode = errCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errCode) {
		this.errorCode = errCode;
	}

	public String getLocalizedMessage() {
		if ((this.errorCode == null) || (this.errorCode.isEmpty())) {
			return getMessage();
		}
		return this.errorMsgLoader.getErrorMessage(this.errorCode) + getMessage();
	}

}
