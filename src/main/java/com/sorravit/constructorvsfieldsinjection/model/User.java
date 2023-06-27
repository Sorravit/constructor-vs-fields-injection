package com.sorravit.constructorvsfieldsinjection.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String username;
    private String email;
    private Address address;
}
