package com.ledungcobra.addressservice.controller;

import com.ledungcobra.addressservice.request.CreateAddressRequest;
import com.ledungcobra.addressservice.response.AddressResponse;
import com.ledungcobra.addressservice.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
@Slf4j
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
        log.info("Get by id");
        return addressService.getById(id);
    }
}
