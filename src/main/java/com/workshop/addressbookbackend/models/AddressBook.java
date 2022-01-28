package com.workshop.addressbookbackend.models;

import com.workshop.addressbookbackend.dto.AddressBookDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor  //Used lombok library to create default constructor.
@Getter //Used to generate getters.
@Setter //Used to generate setters.
public class AddressBook {
	
	/** Private variables. ***/
	private long id;
	private String full_name;
	private String address;
	private long phone_number;
	private String city;
	private String state;
	private int zip_code;
	
	/** Parameterized Constructor. **/
	public AddressBook(long id, AddressBookDTO addressBookDTO) {
		this.id = id;
		this.full_name = addressBookDTO.full_name;
		this.address = addressBookDTO.address;
		this.phone_number = addressBookDTO.phone_number;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zip_code = addressBookDTO.zip_code;
	}
}
