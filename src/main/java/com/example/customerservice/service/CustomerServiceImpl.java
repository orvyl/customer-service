package com.example.customerservice.service;

import com.example.customerservice.model.Customer;
import com.example.customerservice.payload.CreateCustomerRequest;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setMiddleName(request.getMiddleName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPassword(request.getPassword());
        customer.setPresentAddress(customer.getPresentAddress());
        customer.setPermanentAddress(customer.getPermanentAddress());

        return customerRepository.save(customer);
    }
}
