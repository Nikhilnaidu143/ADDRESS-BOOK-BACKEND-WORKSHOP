package com.workshop.addressbookbackend.services;

import java.util.List;

import com.workshop.addressbookbackend.dto.AddressBookDTO;
import com.workshop.addressbookbackend.exceptions.AddressBookException;
import com.workshop.addressbookbackend.models.AddressBook;

public interface IAddressBookService {

	/*** UC-2.2 :- Introducing Services Layer in AddressBook App. ***/

	/*** Declaring methods. ***/
	public String sayHello();

	public List<AddressBook> getAllAddressBooksInList();

	public AddressBook getAddressBookDataById(long id) throws AddressBookException;
	
	public List<AddressBook> getAddressBooksByCity(String city);

	public AddressBook createAddressBook(AddressBookDTO addressBookDTO);

	public AddressBook updateAddressBookById(AddressBookDTO addressBookDTO, String id) throws AddressBookException;

	public String deleteAddressBookById(long id);
}
