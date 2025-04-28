package com.example.AddressBook.controller;

import com.example.AddressBook.model.AddressBookDTO;
import com.example.AddressBook.model.AddressBookData;
import com.example.AddressBook.service.AddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @PostMapping("/create")
    public ResponseEntity<AddressBookData> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData saveData = addressBookService.saveAddressBook(addressBookDTO);
        return ResponseEntity.ok(saveData);
    }

    @GetMapping("/get")
    public ResponseEntity<List<AddressBookData>> getAllAddressBooks() {
        List<AddressBookData> list = addressBookService.getAllAddressBooks();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookData> getAddressBookById(@PathVariable int id) {
        AddressBookData result = addressBookService.getAddressBookById(id)
                .orElseThrow(() -> new RuntimeException("Address Book entry not found with ID: " + id));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/city/{city}/state/{state}")
    public ResponseEntity<List<AddressBookData>> getAddressBookByCityAndState(@PathVariable String city, @PathVariable String state) {
        List<AddressBookData> result = addressBookService.getAddressBookByCityAndState(city, state);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressBookById(@PathVariable int id) {
        addressBookService.deleteAddressBookById(id);
        return ResponseEntity.ok("Deleted " + id + " successfully");
    }
}
