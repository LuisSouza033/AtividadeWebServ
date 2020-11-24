package com.fafram.webservice.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_Phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer number;
    private Customer customer;


    @ManyToOne
    private Customer customers;

    public Phone(){
    }
    public Phone(Long id, String name, Integer number, Customer customer){
        this.id = id;
        this.name = name;
        this.number = number;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Customer> getCustomers() {
        return (Set<Customer>) customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = (Customer) customers;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return id.equals(phone.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
