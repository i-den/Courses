package com.example.demo.shared.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 8019794749168241828L;

    private long id;

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String encryptedPassword;

    private String emailVerificationToken;

    private Boolean emailVerificationStatus = false;

    private List<AddressDTO> addresses;
}
