package com.trainingapp.exceptions;

public class CourseNotFoundException extends RuntimeException{
	
	
	public CourseNotFoundException() {
		super();
	}

	public CourseNotFoundException(String message) {
		super(message);
	}
	


}
