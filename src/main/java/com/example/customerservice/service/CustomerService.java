package com.example.customerservice.service;

import com.example.customerservice.model.Customer;
import com.example.customerservice.payload.CreateCustomerRequest;

public interface CustomerService {
    Customer createCustomer(CreateCustomerRequest request);
}
