package com.sorravit.constructorvsfieldsinjection.model;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String username;
    private String email;
    private Address address;
    private String phoneNumber;
}
