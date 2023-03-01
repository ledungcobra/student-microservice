package com.ledungcobra.addressservice.service;


import com.ledungcobra.addressservice.entity.Address;
import com.ledungcobra.addressservice.repository.AddressRepository;
import com.ledungcobra.addressservice.request.CreateAddressRequest;
import com.ledungcobra.addressservice.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest){
        var address = new Address();
        address.setCity(createAddressRequest.getCity());
        address.setStreet(createAddressRequest.getStreet());
        addressRepository.save(address);
        return new AddressResponse(address);
    }

    public AddressResponse getById(long id) {
        return new AddressResponse(addressRepository.findById(id).orElseGet(Address::new));
    }
}
