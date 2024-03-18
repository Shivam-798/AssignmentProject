package com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GolbalExceptionHandler {
	
	@ExceptionHandler(ResouceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExcptionHandler(ResouceNotFoundException e){
		
		String message=e.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}

}
