package com.ledungcobra.addressservice.controller;

import com.ledungcobra.addressservice.request.CreateAddressRequest;
import com.ledungcobra.addressservice.response.AddressResponse;
import com.ledungcobra.addressservice.service.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest){
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id){
        return addressService.getById(id);
    }
}
