package com.coda.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.coda.exception.VoteException;

@RestControllerAdvice
public class CodaExceptionHandler {
			@ExceptionHandler(value= {VoteException.class})
			@ResponseStatus(code=HttpStatus.NOT_FOUND)
			public Map<String,String> handleException(Exception ex) {
				Map<String, String> map = new HashMap<>();
				map.put("message", ex.getMessage());
				return map;
			}
	}


