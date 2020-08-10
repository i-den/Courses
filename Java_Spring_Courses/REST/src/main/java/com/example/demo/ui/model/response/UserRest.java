package com.example.demo.ui.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserRest {

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private List<AddressRest> addresses;
}
