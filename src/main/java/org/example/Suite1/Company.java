package org.example;

import lombok.Getter;

import java.util.List;

@Getter
public class Company {
    private String name;
    private Address address;
    private List<Person> personList;

    public Company(String name, Address address, List<Person> personList) {
        this.name = name;
        this.address = address;
        this.personList = personList;
    }
}
