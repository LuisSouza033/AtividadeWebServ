package com.fafram.webservice.services;
import com.fafram.webservice.entities.Customer;
import com.fafram.webservice.entities.Phone;
import com.fafram.webservice.repositories.CustomerRepository;
import com.fafram.webservice.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(Long id) {
        Optional<Customer> obj = repository.findById(id);
        return obj.get();
    }
}
