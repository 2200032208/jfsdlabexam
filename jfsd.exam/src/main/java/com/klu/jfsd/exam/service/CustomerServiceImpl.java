package com.klu.jfsd.exam.service;

import com.klu.jfsd.exam.model.Customer;
import com.klu.jfsd.exam.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> updateCustomer(Long id, String name, String address) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setName(name);
            customer.setAddress(address);
            customerRepository.save(customer);
            return Optional.of(customer);
        }

        return Optional.empty();
    }
}
