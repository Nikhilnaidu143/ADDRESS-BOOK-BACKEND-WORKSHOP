package com.workshop.addressbookbackend.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.workshop.addressbookbackend.dto.AddressBookDTO;
import com.workshop.addressbookbackend.models.AddressBook;

@Service
public class AddressBookService implements IAddressBookService {

	/** Create object(COUNTER) of atomic long to auto generate id. **/
	private static final AtomicLong COUNTER = new AtomicLong();
	
	/*** UC-2.2 :- Introducing Services Layer in AddressBook App. ***/

	/*** Defining implemented methods from IAddressBookService interface. ***/
	@Override
	public String sayHello() {
		String helloMessage = "Hello Nikhil, Welcome to address book backend application..!";
		return helloMessage;
	}

	/** Get address book details by using id. **/
	@Override
	public AddressBook getAddressBookDataById(long id) {
		AddressBook addressBook = new AddressBook(COUNTER.incrementAndGet() , new AddressBookDTO("Nikhil", "pellur", 939835963 , "Ongole" , "AP" , 523272));
		return addressBook;
	}

	/** Create address book **/
	@Override
	public AddressBook createAddressBook(AddressBookDTO addressBookDTO) {
		AddressBook addressBook = new AddressBook(COUNTER.incrementAndGet() , addressBookDTO);
		return addressBook;
	}

	/** Update address book by using id. **/
	@Override
	public AddressBook updateAddressBookById(AddressBookDTO addressBookDTO, String id) {
		AddressBook addressBook = new AddressBook(Long.parseLong(id), addressBookDTO);
		return addressBook;
	}

	/** Delete address book by using id. **/
	@Override
	public String deleteAddressBookById(long id) {
		String message = "Deleted id :- " + id;
		return message;
	}
}
