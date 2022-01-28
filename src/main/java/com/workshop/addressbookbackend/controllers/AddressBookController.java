package com.workshop.addressbookbackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	/***
	 * UC-1 :- Create a Address Book Spring Project to cater to REST Request from
	 * Address Book UI.
	 ***/
	@GetMapping(value = { "", "/", "home" })
	public String sayHello() {
		return "Hello Nikhil, Welcome To Address Book Backend Application...!";
	}

	/***
	 * UC-2 :- Create a Rest Controller to demonstrate the various HTTP Methods.
	 ***/

	/*** get addressBook by using ID . ***/
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<String> getAddressBook(@PathVariable String id) {
		return new ResponseEntity<String>("Get Request Successfull...!", HttpStatus.OK);
	}

	/*** Creating AddressBook by using POST request. ***/
	@PostMapping(value = "/create")
	public ResponseEntity<String> createAddressBook() {
		return new ResponseEntity<String>("Post Request Successfull...!", HttpStatus.OK);
	}

	/*** Updating already existing address book details ***/
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateAddressBook(@PathVariable Long id) {
		return new ResponseEntity<String>("Put Request Successfull...!", HttpStatus.OK);
	}

	/*** Delete Address Book by using delete Request. ***/
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteAddressBook(@PathVariable Long id) {
		return new ResponseEntity<String>("Delete Request Successfull...!", HttpStatus.OK);
	}
}
