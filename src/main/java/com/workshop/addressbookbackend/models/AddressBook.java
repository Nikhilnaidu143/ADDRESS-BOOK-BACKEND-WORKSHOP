package com.workshop.addressbookbackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.workshop.addressbookbackend.dto.AddressBookDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity   //used to tell hibernate to create table out of the AddressBook class.
@NoArgsConstructor  //Used lombok library to create default constructor.
@Getter //Used to generate getters.
@Setter //Used to generate setters.
public class AddressBook {
	
	/** Private variables. ***/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String full_name;
	private String address;
	private long phone_number;
	private String city;
	private String state;
	private int zip_code;
	private String email;
	
	/** Parameterized constructor. **/
	public AddressBook(AddressBookDTO addressBookDTO) {
		this.full_name = addressBookDTO.full_name;
		this.address = addressBookDTO.address;
		this.phone_number = addressBookDTO.phone_number;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zip_code = addressBookDTO.zip_code;
		this.email = addressBookDTO.email;
	}
	
	/** Parameterized Constructor(Constructor overloading). **/
	public AddressBook(long id, AddressBookDTO addressBookDTO) {
		this.id = id;
		this.full_name = addressBookDTO.full_name;
		this.address = addressBookDTO.address;
		this.phone_number = addressBookDTO.phone_number;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zip_code = addressBookDTO.zip_code;
		this.email = addressBookDTO.email;
	}
}
