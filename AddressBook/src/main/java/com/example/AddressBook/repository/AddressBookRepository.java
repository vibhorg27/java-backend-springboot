package com.example.AddressBook.repository;

import com.example.AddressBook.model.AddressBookDTO;
import com.example.AddressBook.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

    @Query("SELECT a FROM AddressBookData a WHERE a.city = :city AND a.state = :state")
    List<AddressBookData> findByCityAndState(String city, String state);
}
