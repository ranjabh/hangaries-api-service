package com.hungries.controller;


import com.hungries.model.Customer;
import com.hungries.repository.CustomerRepository;
import com.hungries.service.user.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.List;


@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @PostMapping("/customer/register")
    Status registerCustomer(@Valid @RequestBody Customer newCustomer) {

        logger.info("New user: " + newCustomer.toString());

        customerRepository.save(newCustomer);
        return Status.SUCCESS;

    }

    @GetMapping("/customer/loginId")
    ResponseEntity getCustomerByLoginId(@RequestParam String loginId) {

        ResponseEntity responseEntity = new ResponseEntity<List<Customer>>(customerRepository.findByLoginId(loginId), HttpStatus.OK);
        return responseEntity;

    }

    @DeleteMapping("/customer/loginId")
    ResponseEntity deleteCustomerByLoginId(@RequestParam String loginId) {

        ResponseEntity responseEntity = new ResponseEntity<List<Customer>>(customerRepository.deleteByLoginId(loginId), HttpStatus.OK);
        return responseEntity;

    }

    @PutMapping("/customer/update")
    Status updateCustomer(@Valid @RequestBody Customer newCustomer) {

        List<Customer> customers = customerRepository.findByLoginId(newCustomer.getLoginId());
        if (customers.size() == 1) {
            for (Customer customer : customers) {
                customer.setPassword(newCustomer.getPassword());
                customer.setFirstName(newCustomer.getFirstName());
                customer.setMiddleName(newCustomer.getMiddleName());
                customer.setLastName(newCustomer.getLastName());
                customer.setMobileNumber(newCustomer.getMobileNumber());
                customer.setEmailId(newCustomer.getEmailId());
                customer.setRestaurantId(newCustomer.getRestaurantId());
                customer.setStoreId(newCustomer.getStoreId());
                customer.setCustomerActiveStatus(newCustomer.getCustomerActiveStatus());
                customer.setAlternativeContactId(newCustomer.getAlternativeContactId());
                customer.setStartDate(newCustomer.getStartDate());
                customer.setEndDate(newCustomer.getEndDate());

                customerRepository.save(customer);
            }


        } else if (customers.isEmpty()) {
            customerRepository.save(newCustomer);

        } else {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }


}
