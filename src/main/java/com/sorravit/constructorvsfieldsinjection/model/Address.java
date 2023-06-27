package com.sorravit.constructorvsfieldsinjection.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Address details")
public class Address {

    @Schema(description = "The address", example = "11 Street")
    private String address;

    @Schema(description = "The postal code", example = "1150")
    private String postCode;

    // Getters and setters
}