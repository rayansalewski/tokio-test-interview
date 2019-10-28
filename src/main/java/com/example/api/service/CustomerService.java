package com.example.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.api.domain.Address;
import com.example.api.domain.Customer;
import com.example.api.exception.ResourceNotFoundException;
import com.example.api.repository.AddressRepository;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	
	private AddressRepository addressRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
		this.customerRepository = customerRepository;
		this.addressRepository = addressRepository;
	}

	public Page<Customer> findAll(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		return customerRepository.findAll(pageRequest);
	}

	public Customer findById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer id " + id + " not found"));
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public void delete(Long id) throws ResourceNotFoundException {
		try {
			customerRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Customer cannot be deleted, id " + id + " not found");
		}

	}

	public void update(Customer customer, Long id) throws ResourceNotFoundException {
		findById(id);
		customerRepository.save(customer);
	}

	public Address saveAddress(Long idCustumer, Address address) {
		Customer customer = findById(idCustumer);
		address.setCustomer(customer);
		
		return addressRepository.save(address);
	}
}
