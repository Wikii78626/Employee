package com.solelogic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.solelogic.CustomException;
import com.solelogic.CustomizeErrorResponse;
import com.solelogic.EmployeeNotFound;
import com.solelogic.MethodArgumentNotValid;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<CustomizeErrorResponse> handleCustomerNotFoundException(RuntimeException ex) {
//
//		CustomizeErrorResponse response = new CustomizeErrorResponse();
//		response.setErrorMessage("Error occurs");
//		response.setStatus(HttpStatus.NOT_FOUND);
//		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//	}
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<CustomizeErrorResponse> handleEmployeeByIdNotFound(CustomException ex) {
		CustomizeErrorResponse response = new CustomizeErrorResponse();
		response.setErrorMessage(ex.getMessage());
		response.setErrorCode(ex.getErrorCode());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<CustomizeErrorResponse> handleEmployeeByLocationNotFound(EmployeeNotFound em) {
		CustomizeErrorResponse response = new CustomizeErrorResponse();
		response.setErrorMessage(em.getMessage());
		response.setErrorCode(em.getErrorCode());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValid.class)
	public ResponseEntity<CustomizeErrorResponse> handleMethodArgument(MethodArgumentNotValid met) {
		CustomizeErrorResponse response = new CustomizeErrorResponse();
		response.setErrorMessage(met.getMsg());
		// response.setErrorCode(em.getErrorCode());
		response.setStatus(met.getStatus());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}

	/*
	 * @ExceptionHandler(RuntimeException.class) public
	 * ResponseEntity<CustomizeErrorResponse>
	 * handleEmployeeException(RuntimeException ex) { CustomizeErrorResponse
	 * response = new CustomizeErrorResponse();
	 * response.setErrorMessage(ex.getMessage()); return new
	 * ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */

	/*
	 * @ExceptionHandler(Exception.class) public final ResponseEntity<Object>
	 * handleAllExceptions(Exception ex, WebRequest request) { ExceptionResponse
	 * exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	 * request.getDescription(false)); return new ResponseEntity(exceptionResponse,
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * @ExceptionHandler(EmployeeNotFound.class) public final ResponseEntity<Object>
	 * handleUserNotFoundException(EmployeeNotFound ex, WebRequest request) {
	 * ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
	 * ex.getMessage(), request.getDescription(false)); return new
	 * ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND); }
	 * 
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) { ExceptionResponse
	 * exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
	 * ex.getBindingResult().toString()); return new
	 * ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST); }
	 */
}
