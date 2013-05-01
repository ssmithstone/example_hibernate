package com.lbi.examples.springhibernate;


public class Person {
    private Long id;
    private String name;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }
}
