package com.example.demo.service;

import com.example.demo.io.entity.AddressEntity;
import com.example.demo.io.entity.UserEntity;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.shared.dto.AddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    public AddressServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressDTO> getAddresses(String id) {
        UserEntity userEntity = userRepository.findByUserId(id);

        if (userEntity == null) {
            return new ArrayList<>();
        }

        Iterable<AddressEntity> addresses = addressRepository.findAllByUserDetails(userEntity);
        List<AddressDTO> returnValue = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (AddressEntity address : addresses) {
            returnValue.add(modelMapper.map(address, AddressDTO.class));
        }

        return returnValue;
    }
}
