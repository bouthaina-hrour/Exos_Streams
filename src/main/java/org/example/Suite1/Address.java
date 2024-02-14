package org.example;

import lombok.Getter;

@Getter
public class Address {
    private String street;
    private City city;

    public Address(String street, City city) {
        this.street = street;
        this.city = city;
    }
}
