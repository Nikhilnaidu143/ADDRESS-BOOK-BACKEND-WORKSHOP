package com.workshop.addressbookbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class ResponseDTO {
	
	/** Private variables. **/
	private String message;
	private Object data;
}
