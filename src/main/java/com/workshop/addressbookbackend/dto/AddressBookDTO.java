package com.workshop.addressbookbackend.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor // used Lombok library to create parameterized constructor.
public class AddressBookDTO {

	/*** UC-2.1 :- Introducing DTO and Model to AddressBook App. ***/

	/** variables. **/
	public String full_name;
	public String address;
	public long phone_number;
	public String city;
	public String state;
	public int zip_code;
}
