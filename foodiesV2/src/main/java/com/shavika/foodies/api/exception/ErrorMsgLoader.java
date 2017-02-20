package com.shavika.foodies.api.exception;

import java.util.ResourceBundle;

public class ErrorMsgLoader {

	private static final String PROP_FILE_NAME = "ShavikaErrorMsg";
	private ResourceBundle propertyBundle;

	public String getErrorMessage(String errorKey) {
		getPropertiesBundle();
		if (this.propertyBundle.containsKey(errorKey)) {
			return this.propertyBundle.getString(errorKey);
		}
		return null;
	}

	private ResourceBundle getPropertiesBundle() {
		this.propertyBundle = ResourceBundle.getBundle(PROP_FILE_NAME);
		return this.propertyBundle;
	}

}
