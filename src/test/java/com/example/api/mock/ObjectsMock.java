package com.example.api.mock;

import com.example.api.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class ObjectsMock {

    public Customer customerValid(Long id, String name, String email) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        return customer;
    }

}
