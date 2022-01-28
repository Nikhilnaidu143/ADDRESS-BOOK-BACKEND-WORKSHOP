package com.workshop.addressbookbackend.dto;

import javax.validation.constraints.Email;
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
	@Pattern(regexp = "^[\\w\\s-,]{2,}$" , message = "Address validation failed..!")
	public String address;

	@NotNull(message = "Phone number cannot be null..!")
	public long phone_number;
	
	@Pattern(regexp = "^[A-Za-z\\s]{2,}$" , message = "City validation failed..!")
	public String city;

	@Pattern(regexp = "^[A-Za-z\\s]{2,}$" , message = "State validation failed..!")
	public String state;
	
	@NotNull(message = "Zip code cannot be null..!")
	public int zip_code;
	
	@Email(regexp = "^[\\w+-]+(\\.[\\w+-]+)*@[\\w]+(\\.[\\w]+)?(?=(\\.[A-Za-z_]{2,3}$|\\.[a-zA-Z]{2,3}$)).*$" , message = "Email validation failed...!")
	public String email;
}

