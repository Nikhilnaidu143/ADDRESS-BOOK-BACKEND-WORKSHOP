package com.workshop.addressbookbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workshop.addressbookbackend.models.AddressBook;

/*** creating repository. ***/
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
	
	/*** Custom query. ***/
	@Query(value = "SELECT * FROM address_book WHERE city = :city" , nativeQuery = true)
	List<AddressBook> findAddressBooksByCity(String city);
}
