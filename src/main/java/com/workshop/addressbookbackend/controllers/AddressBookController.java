package com.workshop.addressbookbackend.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.addressbookbackend.dto.AddressBookDTO;
import com.workshop.addressbookbackend.dto.ResponseDTO;
import com.workshop.addressbookbackend.models.AddressBook;
import com.workshop.addressbookbackend.services.AddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired // AutoWired annotation is used for automatic dependency injection.
	private AddressBookService addressBookService;

	/*** Returning simple hello message for checking. ***/
	@GetMapping(value = { "", "/", "home" })
	public ResponseEntity<String> sayHello() {
		String message = addressBookService.sayHello();
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	/***
	 * UC-2 :- Create a Rest Controller to demonstrate the various HTTP Methods.
	 ***/

	/*** get all addressBooks. ***/
	@GetMapping(value = "/getAll")
	public ResponseEntity<ResponseDTO> getAllAddressBooks() {
		List<AddressBook> addressBook = addressBookService.getAllAddressBooksInList();
		ResponseDTO responseDTO = new ResponseDTO("Get All Request Successfull...!", addressBook);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** get addressBook by using ID . ***/
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBook(@PathVariable String id) {
		AddressBook addressBook = addressBookService.getAddressBookDataById(Long.parseLong(id));
		ResponseDTO responseDTO = new ResponseDTO("Get By ID Request Successfull...!", addressBook);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Creating AddressBook by using POST request. ***/
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBook addressBookData = addressBookService.createAddressBook(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Post Request Successfull...!", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Updating already existing address book details ***/
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO,
			@PathVariable String id) {
		AddressBook addressBookData = addressBookService.updateAddressBookById(addressBookDTO, id);
		ResponseDTO responseDTO = new ResponseDTO("Put Request Successfull...!", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Delete Address Book by using delete Request. ***/
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable long id) {
		String message = addressBookService.deleteAddressBookById(id);
		ResponseDTO responseDTO = new ResponseDTO("Delete Request Successfull...!", message);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}