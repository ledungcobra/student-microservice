package com.ledungcobra.addressservice.repository;

import com.ledungcobra.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
