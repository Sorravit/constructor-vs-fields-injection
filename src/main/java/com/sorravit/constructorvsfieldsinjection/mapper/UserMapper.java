package com.sorravit.constructorvsfieldsinjection.mapper;

import com.sorravit.constructorvsfieldsinjection.model.Address;
import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.model.UserDTO;

import static java.util.Optional.ofNullable;

public class UserMapper {
    public User mapUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        Address address = new Address();
        ofNullable(userDTO.getAddress()).ifPresent(
                userDTOaddress->{
                    address.setAddress(userDTOaddress.getAddress());
                    address.setPostCode(userDTOaddress.getPostCode());
                    user.setAddress(address);
                }
        );
        return user;
    }
}
