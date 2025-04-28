package com.example.AddressBook.service;

import com.example.AddressBook.model.AddressBookDTO;
import com.example.AddressBook.model.AddressBookData;
import com.example.AddressBook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
@Service
public class AddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBookData saveAddressBook(AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = new AddressBookData();
        addressBookData.setName(addressBookDTO.getName());
        addressBookData.setEmail(addressBookDTO.getEmail());
        return addressBookRepository.save(addressBookData);
    }
    public List<AddressBookData> getAllAddressBooks(){
        return addressBookRepository.findAll();
    }
    public Optional<AddressBookData> getAddressBookById(int id){
        return addressBookRepository.findById(id);
    }

    //Method to get address book by city and state
    public List<AddressBookData> getAddressBookByCityAndState(String city, String state){
        return addressBookRepository.findByCityAndState(city, state);
    }

    public void deleteAddressBookById(int id){
        addressBookRepository.deleteById(id);
    }

    //convert to DTO
    public AddressBookDTO convertToDTO(AddressBookData addressBookData) {
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setName(addressBookData.getName());
        addressBookDTO.setEmail(addressBookData.getEmail());
        return addressBookDTO;
    }
    //convert to entity
    public AddressBookData convertToEntity(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData();
        addressBookData.setName(addressBookDTO.getName());
        addressBookData.setEmail(addressBookDTO.getEmail());
        return addressBookData;
    }
}
