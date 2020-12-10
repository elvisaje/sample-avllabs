package com.avllabs.sample.api;

import java.util.Optional;
import javax.validation.Valid;

import com.avllabs.sample.entity.Address;
import com.avllabs.sample.service.AddressService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v2", produces = "application/json")
public class AddressApi {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public ResponseEntity<Page<Address>> findAll(Pageable pag) {
        return new ResponseEntity(addressService.findAll(pag), HttpStatus.OK);
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {

        Optional<Address> result = addressService.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/addresses")
    public ResponseEntity<Address> save(@Valid @RequestBody Address newAddress) {
        return new ResponseEntity(addressService.save(newAddress), HttpStatus.CREATED);
    }

    @PutMapping("/addresses")
    public ResponseEntity<Address> update(@Valid @RequestBody Address updatedAddress) {

        Long id = (updatedAddress.getId() == null) ? -1 : updatedAddress.getId();

        Optional<Address> p = addressService.findById(id).map(address -> {

            address.setState(updatedAddress.getStreet());
            address.setCity(updatedAddress.getCity());
            address.setState(updatedAddress.getState());
            address.setPostalCode(updatedAddress.getPostalCode());
            address.setCountry(updatedAddress.getCountry());

            return addressService.save(address);
        });

        return new ResponseEntity(p.get(), HttpStatus.OK);
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        addressService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
