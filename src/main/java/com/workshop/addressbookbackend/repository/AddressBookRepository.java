package com.workshop.addressbookbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.addressbookbackend.models.AddressBook;

/*** creating repository. ***/
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {

}
