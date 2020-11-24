package com.fafram.webservice.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_Customer")
public class Customer {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Phone> phones;

    public Customer(){
    }
    public Customer(Long id, String name, String email, String cpf)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }
    private List<Phone> phone = new ArrayList<>( );

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
