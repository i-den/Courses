package com.denchevgod.petclinic.services.jpa;

import com.denchevgod.petclinic.model.Owner;
import com.denchevgod.petclinic.repository.OwnerRepository;
import com.denchevgod.petclinic.repository.PetRepository;
import com.denchevgod.petclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJPAServiceTest {

    private final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJPAService ownerService;

    Owner returned;

    @BeforeEach
    void setUp() {
        returned = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerService.findByLastName(any())).thenReturn(returned);
        Owner winstonSmith = ownerService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, winstonSmith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwnerSet = new HashSet<>();
        returnedOwnerSet.add(Owner.builder().id(1L).build());
        returnedOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);

        Set<Owner> owners = ownerService.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returned));
        Owner owner = ownerService.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returned);

        Owner savedOwner = ownerService.save(ownerToSave);

        assertNotNull(savedOwner);
        assertEquals(savedOwner, returned);
    }

    @Test
    void delete() {
        ownerService.delete(returned);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}