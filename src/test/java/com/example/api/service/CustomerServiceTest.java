package com.example.api.service;

import com.example.api.domain.Customer;
import com.example.api.exception.ResourceNotFoundException;
import com.example.api.mock.ObjectsMock;
import com.example.api.repository.AddressRepository;
import com.example.api.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    CustomerService customerService;

    ObjectsMock objMocks = new ObjectsMock();

    @Test
    public void shouldTakeACostumersById() {
        Customer customer = objMocks.customerValid(2L, "Tiba Meia-Choppa", "tibaPatins@gmail.com");

        when(customerRepository.findById(2L)).thenReturn(ofNullable(customer));
        assertDoesNotThrow(() -> customerService.findById(customer.getId()));

    }

    @Test
    public void shouldThrowsExceptions() {
        Customer customer = objMocks.customerValid(1L, "Tiba Meia-Choppa", "tibaPatins@gmail.com");

        lenient().when(customerRepository.findById(5L)).thenReturn(ofNullable(customer));
        assertThrows(ResourceNotFoundException.class, () -> customerService.findById(customer.getId()));

    }
}
