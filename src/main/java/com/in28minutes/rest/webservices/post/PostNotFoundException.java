package com.in28minutes.rest.webservices.post;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2875753735136836547L;

	public PostNotFoundException(String message) {
		super(message);
	}
}
