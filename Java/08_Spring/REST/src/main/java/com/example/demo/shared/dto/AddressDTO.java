package com.example.demo.shared.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private long id;

    private String addressId;

    private String city;

    private String country;

    private String streetName;

    private String postalCode;

    private String type;

    private UserDto userDetails;
}
