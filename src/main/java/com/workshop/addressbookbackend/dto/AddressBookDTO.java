package com.workshop.addressbookbackend.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // used Lombok library to create parameterized constructor.
public @ToString class AddressBookDTO {

	/*** UC-2.1 :- Introducing DTO and Model to AddressBook App. ***/

	/** variables. **/
	@NotNull(message = "Full Name cannot be null..!")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Full Name validation failed..!")
	public String full_name;
	
	@NotNull(message = "Address cannot be null..!")
	@NotEmpty(message = "Address cannot be empty..!")
	public String address;
	
	public long phone_number;
	
	public String city;
	
	public String state;
	
	public int zip_code;
}
