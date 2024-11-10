package com.veda.grampanchayat.exceptions;

public class ResidentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResidentNotFoundException(String message) {
		super(message);
	}

}
