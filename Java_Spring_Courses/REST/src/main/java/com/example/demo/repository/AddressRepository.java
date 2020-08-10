package com.example.demo.repository;

import com.example.demo.io.entity.AddressEntity;
import com.example.demo.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

    Iterable<AddressEntity> findAllByUserDetails(UserEntity userEntity);
}
