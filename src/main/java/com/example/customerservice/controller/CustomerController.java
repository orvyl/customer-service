package com.example.customerservice.controller;

import com.example.customerservice.model.Customer;
import com.example.customerservice.payload.CreateCustomerRequest;
import com.example.customerservice.payload.CreateCustomerResponse;
import com.example.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("customer")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateCustomerResponse createCustomer(@Valid @RequestBody CreateCustomerRequest request) {
        log.info("Received create customer: {}", request);
        Customer customer = customerService.createCustomer(request);

        CreateCustomerResponse response = new CreateCustomerResponse();
        response.setCustomerId(customer.getId());

        return response;
    }
}
