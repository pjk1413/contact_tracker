package com.kramer.contactTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kramer.contactTracker.models.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
