package com.workshop.addressbookbackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.workshop.addressbookbackend.dto.AddressBookDTO;
import com.workshop.addressbookbackend.exceptions.AddressBookException;
import com.workshop.addressbookbackend.models.AddressBook;

@Service // Service annotation tells spring framework that this class is under service
			// layer.
public class AddressBookService implements IAddressBookService {

	/**
	 * UC-2.3 :- Ability for the Services Layer to store the AddressBook Data.
	 **/
	private static List<AddressBook> addressBookList = new ArrayList<AddressBook>();

	private static final AtomicLong COUNTER = new AtomicLong(); // to auto increment the id.

	/** Returning address book for crud operations. **/
	private static AddressBook returnAddressBookById(long id) {
		return addressBookList.stream().filter(addressBook -> addressBook.getId() == id).findFirst().orElse(null);
	}

	/*** Defining implemented methods from IAddressBookService interface. ***/
	@Override // to return simple hello message for checking.
	public String sayHello() {
		String helloMessage = "Hello Nikhil, Welcome to address book backend application..!";
		return helloMessage;
	}

	/*** Get All address books in the list. ***/
	@Override
	public List<AddressBook> getAllAddressBooksInList() {
		List<AddressBook> allAddressBooks = addressBookList;
		return allAddressBooks;
	}

	/***
	 * Getting addressBook by ID.
	 * 
	 * @throws AddressBookException
	 ***/
	@Override
	public AddressBook getAddressBookDataById(long id) throws AddressBookException {
		AddressBook addressBook = returnAddressBookById(id); // returning addressBook.
		if (addressBook == null) {
			throw new AddressBookException("ID not found...!"); // throw custom exception.
		} else {
			return addressBook;
		}
	}

	/*** Creating address book. ***/
	@Override
	public AddressBook createAddressBook(AddressBookDTO addressBookDTO) {
		AddressBook addressBook = new AddressBook(COUNTER.incrementAndGet(), addressBookDTO);
		addressBookList.add(addressBook);
		return addressBook;
	}

	/***
	 * Updating address book by id.
	 * 
	 * @throws AddressBookException
	 ***/
	@Override
	public AddressBook updateAddressBookById(AddressBookDTO addressBookDTO, String id) throws AddressBookException {
		AddressBook addressBook = returnAddressBookById(Long.parseLong(id));

		if (addressBook == null) {
			throw new AddressBookException("ID not found...!"); // throw custom exception.
		} else {
			addressBook.setFull_name(addressBookDTO.full_name);
			addressBook.setAddress(addressBookDTO.address);
			addressBook.setPhone_number(addressBookDTO.phone_number);
			addressBook.setCity(addressBookDTO.city);
			addressBook.setState(addressBookDTO.state);
			addressBook.setZip_code(addressBookDTO.zip_code);

			return addressBook; // returning updated addressbook.
		}
	}

	/*** Delete address book by id. ***/
	@Override
	public String deleteAddressBookById(long id) {
		addressBookList.remove(returnAddressBookById(id));
		String message = "Deleted id :- " + id;
		return message;
	}
}