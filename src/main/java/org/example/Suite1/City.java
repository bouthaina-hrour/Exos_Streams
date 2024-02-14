package org.example;

import lombok.Getter;

@Getter
public class City {
    private String name;
    private State state;

    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }
}
