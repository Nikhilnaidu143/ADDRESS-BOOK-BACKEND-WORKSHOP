package com.workshop.addressbookbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor //Used to auto generate default constructor in the source time.
public @Data class ResponseDTO {
	
	/** Private variables. **/
	private String message;
	private Object data;
}
