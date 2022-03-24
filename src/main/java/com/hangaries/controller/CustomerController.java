package com.hangaries.controller;


import com.hangaries.constants.Status;
import com.hangaries.model.Customer;
import com.hangaries.repository.CustomerRepository;
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
    CustomerRepository customerRepository;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @GetMapping("/customer/register")
    Status registerCustomer() {
        Customer customer=new Customer();
        customer.setEmailId("ranjan.ab@gmail.com");
        customer.setMobileNumber("9199911");
        customer.setFirstName("Abhishek");
        customer.setMiddleName("Ranjan");
        customer.setCustomerActiveStatus("Yes");
        customer.setLastName("RRR");
        customer.setLoginId("Abhishek1234");
        customer.setPassword("***");
       logger.info("New user: " + customer.toString());

        customerRepository.save(customer);
        return Status.SUCCESS;

    }

    @GetMapping("/customer/loginId")
    ResponseEntity getCustomerByLoginId() {

        ResponseEntity responseEntity = new ResponseEntity<List<Customer>>(customerRepository.findByLoginId("hungries"), HttpStatus.OK);
        return responseEntity;

    }
    @GetMapping("/customer/getDtlsbyId")
    List<Customer> getCustomersById(){
        Long id=1L;
        List<Customer> customers=customerRepository.findAll();
        return customers;
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
