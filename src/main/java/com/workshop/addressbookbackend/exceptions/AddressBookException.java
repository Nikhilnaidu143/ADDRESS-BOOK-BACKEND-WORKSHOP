package com.workshop.addressbookbackend.exceptions;

/**
 * UC-4.3:- Ability to throw User Friendly Errors in case Address Book Id is not
 * found in Address Book App.
 **/

public class AddressBookException extends Exception {

	/** Custom Exception class. **/
	public AddressBookException(String message) {
		super(message);
	}
}