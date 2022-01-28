package com.workshop.addressbookbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.addressbookbackend.dto.AddressBookDTO;
import com.workshop.addressbookbackend.exceptions.AddressBookException;
import com.workshop.addressbookbackend.models.AddressBook;
import com.workshop.addressbookbackend.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service // Service annotation tells spring framework that this class is under service layer.
@Slf4j
public class AddressBookService implements IAddressBookService {

	@Autowired //used to achieve automatic dependency injection.
	private AddressBookRepository addressBookRepository;
	
	/*** Defining implemented methods from IAddressBookService interface. ***/
	@Override // to return simple hello message for checking.
	public String sayHello() {
		String helloMessage = "Hello Nikhil, Welcome to address book backend application..!";
		return helloMessage;
	}

	/*** Get All address books in the list. ***/
	@Override
	public List<AddressBook> getAllAddressBooksInList() {
		return addressBookRepository.findAll();
	}

	/***
	 * Getting addressBook by ID.
	 * 
	 * @throws AddressBookException
	 ***/
	@Override
	public AddressBook getAddressBookDataById(long id) throws AddressBookException {
		Optional<AddressBook> findAddressBook = addressBookRepository.findById(id);
		if(!findAddressBook.isPresent()) {
			throw new AddressBookException("ID not found...!"); // throw custom exception.
		}
		else {
			return findAddressBook.get();
		}
	}

	/*** Custom query:- Find address book by city. ***/
	@Override
	public List<AddressBook> getAddressBooksByCity(String city) {
		return addressBookRepository.findAddressBooksByCity(city);
	}
	
	/*** Creating address book. ***/
	@Override
	public AddressBook createAddressBook(AddressBookDTO addressBookDTO) {
		AddressBook addressBook = new AddressBook(addressBookDTO);
		log.info("Address Book data :- " + addressBook.toString());
		return addressBookRepository.save(addressBook);  //added to the database.
	}

	/***
	 * Updating address book by id.
	 * 
	 * @throws AddressBookException
	 ***/
	@Override
	public AddressBook updateAddressBookById(AddressBookDTO addressBookDTO, String id) throws AddressBookException {
		Optional<AddressBook> findAddressBook = addressBookRepository.findById(Long.parseLong(id));
		if (!findAddressBook.isPresent()) {
			throw new AddressBookException("ID not found...!"); // throw custom exception.
		} 
		else {
			return addressBookRepository.save(new AddressBook(Long.parseLong(id) , addressBookDTO));
		}
	}

	/*** Delete address book by id. ***/
	@Override
	public String deleteAddressBookById(long id) {
		Optional<AddressBook> addressBook = addressBookRepository.findById(id);
		if (addressBook.isPresent()) {
			addressBookRepository.deleteById(id);
			return "Deleted AddressBook details successfully.";
		} else {
			return "AddressBook details not found in database.";
		}
	}
}