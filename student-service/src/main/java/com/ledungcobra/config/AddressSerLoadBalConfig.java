package com.ledungcobra.config;


import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient("address-service")
public class AddressSerLoadBalConfig {

    @LoadBalanced
    @Bean
    public Feign.Builder feiBuilder(){
        return Feign.builder();
    }
}
