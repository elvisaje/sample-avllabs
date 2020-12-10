package com.avllabs.sample.service;

import com.avllabs.sample.entity.Address;
import com.avllabs.sample.repository.AddressRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepo;

    public Page<Address> findAll(Pageable pag) {
        return addressRepo.findAll(pag);
    }

    public Optional<Address> findById(Long id) {
        return addressRepo.findById(id);
    }

    public Address save(Address newAddress) {
        newAddress.getPerson().setAddress(newAddress);
        return addressRepo.save(newAddress);
    }

    public void delete(Long id) {
        addressRepo.delete(addressRepo.findById(id).get());
    }

}
