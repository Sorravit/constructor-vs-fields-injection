package com.sorravit.constructorvsfieldsinjection.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorravit.constructorvsfieldsinjection.model.Address;
import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.model.UserDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest {
    protected final ObjectMapper objectMapper = new ObjectMapper();

    private static String readFileToString(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of(filePath));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @Test
    void mapUser() throws IOException {
        UserMapper userMapper = new UserMapper();
        var userDTOJson = readFileToString("/Users/e130741/IdeaProjects/constructor-vs-fields-injection/src/test/java/resources/json/userDTO.json");
        var userDTO = objectMapper.readValue(userDTOJson, UserDTO.class);
        User user = userMapper.mapUser(userDTO);

        User expectedUser = new User();
        expectedUser.setId(1);
        expectedUser.setUsername("john wick");
        expectedUser.setEmail("john.wick@thecontinental.com");
        Address address = new Address();
        address.setPostCode("12345");
        address.setAddress("11 Street");
        expectedUser.setAddress(address);
        assertThat(user).isEqualTo(expectedUser);
    }

    @Test
    void mapUserWithNoAddress() throws IOException {
        UserMapper userMapper = new UserMapper();
        var userDTOJson = readFileToString("/Users/e130741/IdeaProjects/constructor-vs-fields-injection/src/test/java/resources/json/userDTONoAddress.json");
        var userDTO = objectMapper.readValue(userDTOJson, UserDTO.class);
        User user = userMapper.mapUser(userDTO);

        User expectedUser = new User();
        expectedUser.setId(1);
        expectedUser.setUsername("john wick");
        expectedUser.setEmail("john.wick@thecontinental.com");
        assertThat(user).isEqualTo(expectedUser);
    }
}