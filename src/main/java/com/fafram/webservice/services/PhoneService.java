package com.fafram.webservice.services;
import com.fafram.webservice.entities.Phone;
import com.fafram.webservice.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository repository;

    public List<Phone> findAll() {
        return repository.findAll();
    }

    public Phone findById(Long id) {
        Optional<Phone> obj = repository.findById(id);
        return obj.get();
    }
}
