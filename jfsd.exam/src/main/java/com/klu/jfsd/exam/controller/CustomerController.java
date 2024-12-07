package com.klu.jfsd.exam.controller;

import com.klu.jfsd.exam.model.Customer;
import com.klu.jfsd.exam.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestParam String name, @RequestParam String address) {
        return customerService.updateCustomer(id, name, address)
                .map(customer -> ResponseEntity.ok().body("Customer updated successfully: " + customer))
                .orElse(ResponseEntity.notFound().build());
    }
}
