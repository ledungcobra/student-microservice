package com.ledungcobra.feignclients;

import com.ledungcobra.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "api-gateway")
public interface AddressService {
    @GetMapping("/address-service/api/address/getById/{id}")
    AddressResponse getById(@PathVariable long id);
}
