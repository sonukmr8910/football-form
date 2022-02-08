package com.form.footballform.service;

import com.form.footballform.models.Address;
import com.form.footballform.models.City;
import com.form.footballform.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address getAddress(Long id) {
        return addressRepository.getById(id);
    }

    public boolean saveAddress(Address address) {
        addressRepository.save(address);
        return true;
    }

    public boolean saveAddress(Long id, String address, City city, int pinCode) {
        Address a = new Address(id, address, city, pinCode);
        addressRepository.save(a);
        return true;
    }

    public boolean saveAddress(String address, City city, int pinCode) {
        return saveAddress(null, address, city, pinCode);
    }
}
