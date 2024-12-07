package com.klu.jfsd.exam.service;

import com.klu.jfsd.exam.model.Customer;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> updateCustomer(Long id, String name, String address);
}
