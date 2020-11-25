package com.fafram.webservice.config;

import com.fafram.webservice.entities.Customer;
import com.fafram.webservice.entities.Phone;
import com.fafram.webservice.repositories.CustomerRepository;
import com.fafram.webservice.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private PhoneRepository phoneRepository;

    // injeção de dependência
    @Autowired
    private CustomerRepository customerRepository;


    // database seeding
    @Override
    public void run(String... args) throws Exception {

        Phone pho1 = new Phone(null,"Celular", 999984545);
        Phone pho2 = new Phone(null,"Celular", 999984646);
        Phone pho3 = new Phone(null,"Celular", 999984747);

        Customer customer1 = new Customer(null,"Luis","luis@hotmail.com", "123.123.123.12");
        Customer customer2 = new Customer(null,"Marcos","marcos@hotmail.com", "456.456.456.45");
        Customer customer3 = new Customer(null,"Otavio","otavio@hotmail.com", "789.789.789-78");

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        phoneRepository.saveAll(Arrays.asList(pho1, pho2, pho3));

        customer1.getPhones().add(pho1);
        customer1.getPhones().add(pho2);

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));

    }
}
