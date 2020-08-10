package com.example.demo.controller;

import com.example.demo.exceptions.UserServiceException;
import com.example.demo.service.AddressService;
import com.example.demo.service.UserService;
import com.example.demo.shared.dto.AddressDTO;
import com.example.demo.shared.dto.UserDto;
import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.AddressRest;
import com.example.demo.ui.model.response.ErrorMessages;
import com.example.demo.ui.model.response.OperationStatusModel;
import com.example.demo.ui.model.response.UserRest;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final AddressService addressService;

    public UserController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @GetMapping(
            path = "/{id}"
    )
    public UserRest getUser(@PathVariable String id) {
        UserRest returnValue = new UserRest();

        UserDto userDto = userService.getUserByUserId(id);

        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

        if (userDetails.getFirstName().isEmpty()) {
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getMsg());
        }

//        UserDto userDto = new UserDto();
//
//        BeanUtils.copyProperties(userDetails, userDto);
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        UserDto createdUser = userService.createUser(userDto);
        return modelMapper.map(createdUser, UserRest.class);
    }


    @PutMapping("/{id}")
    public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.updateUser(id, userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @DeleteMapping("/{id}")
    public OperationStatusModel deleteUser(@PathVariable String id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        userService.deleteUser(id);
        returnValue.setOperationName("Delete");
        returnValue.setOperationResult("Success");

        return returnValue;
    }

    @GetMapping
    public List<UserRest> getUsers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "2") int limit
    ) {
        List<UserRest> returnValue = new ArrayList<>();
        List<UserDto> users = userService.getUsers(page, limit);

        ModelMapper mapper = new ModelMapper();
        for (UserDto user : users) {
            UserRest userRest = mapper.map(user, UserRest.class);
            returnValue.add(userRest);
        }

        return returnValue;
    }

    @GetMapping(path = "/{id}/addresses")
    public List<AddressRest> getUserAddresses(@PathVariable String id) {
        List<AddressRest> addresses = new ArrayList<>();

        List<AddressDTO> addressDTOS = addressService.getAddresses(id);

        if (addressDTOS != null && !addressDTOS.isEmpty()) {
            Type listType = new TypeToken<List<AddressRest>>() {}.getType();
            addresses = new ModelMapper().map(addressDTOS, listType);
        }

        return addresses;
    }
}
