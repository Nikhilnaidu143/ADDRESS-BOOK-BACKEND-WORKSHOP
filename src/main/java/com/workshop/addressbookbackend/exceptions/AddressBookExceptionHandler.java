package com.workshop.addressbookbackend.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.workshop.addressbookbackend.dto.ResponseDTO;

@ControllerAdvice
public class AddressBookExceptionHandler {

	/*** Constant exception message. ***/
	private static final String MESSAGE = "Exception while procession REST request.";

	/***
	 * UC-4.2:- Provide User Friendly Error Response in case validation fails.
	 ***/

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {

		// getting all errors in the list of ObjectError type
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();

		// Mapping the default message and collect it into errorMessage variable.
		List<String> errorMessage = errorList.stream().map(objectError -> objectError.getDefaultMessage())
				.collect(Collectors.toList());

		ResponseDTO responseDTO = new ResponseDTO(MESSAGE, errorMessage);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST); // returning response entity.
	}

	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<ResponseDTO> handleAddressBookIdNotFoundException(AddressBookException exception) {
		ResponseDTO responseDTO = new ResponseDTO(MESSAGE, exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}