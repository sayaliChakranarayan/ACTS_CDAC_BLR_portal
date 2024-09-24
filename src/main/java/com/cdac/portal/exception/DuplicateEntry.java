package com.cdac.portal.exception;

public class DuplicateEntry extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicateEntry() {
		super("Duplicate User name or mobile number found");
	}
}
