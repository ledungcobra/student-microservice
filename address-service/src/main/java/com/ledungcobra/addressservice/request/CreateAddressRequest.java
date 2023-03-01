package com.ledungcobra.addressservice.request;

import lombok.Data;

@Data
public class CreateAddressRequest {
    private String street;
    private String city;
}
