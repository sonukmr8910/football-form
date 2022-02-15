package com.form.footballform.service;

import com.form.footballform.models.Address;
import com.form.footballform.models.City;
import com.form.footballform.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<Address> getAddress(Long id) {
        return addressRepository.getAddressById(id);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address saveAddress(Long id, String address, City city, int pinCode) {
        Address a = new Address(id, address, city, pinCode);
        return saveAddress(a);
    }

    public Address saveAddress(String address, City city, int pinCode) {
        return saveAddress(null, address, city, pinCode);
    }

    public void deleteAddress(Address address) {
        try {
            addressRepository.delete(address);
        }
        catch (Exception e) {
            // Address could not be deleted
        }
    }
}
