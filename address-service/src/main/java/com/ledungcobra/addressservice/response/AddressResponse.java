package com.ledungcobra.addressservice.response;

import com.ledungcobra.addressservice.entity.Address;
import lombok.Data;

@Data
public class AddressResponse {
    private long addressId;
    private String street;
    private String city;

    public AddressResponse(Address address) {
        this.addressId = address.getId();
        this.city = address.getCity();
        this.street = address.getStreet();
    }
}
