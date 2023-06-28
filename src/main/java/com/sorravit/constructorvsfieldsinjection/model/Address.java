package com.sorravit.constructorvsfieldsinjection.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Address details")
public class Address {
    @NotEmpty
    @Schema(description = "The address", example = "11 Street")
    private String address;

    @NotEmpty
    @Size(min = 5, max = 5)
    @Schema(description = "Five digit postal code", example = "11500")
    private String postCode;

    // Getters and setters
}