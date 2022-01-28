package com.workshop.addressbookbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // Used to auto generate default constructor in the source time.
public @Data class ResponseDTO {

	/***
	 * UC-3.1:- Use Lombok Library to auto generate getters and setters for the DTO.
	 ***/

	/** Private variables. **/
	private String message;
	private Object data;
}
