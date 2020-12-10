package com.avllabs.sample.repository;

import com.avllabs.sample.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
