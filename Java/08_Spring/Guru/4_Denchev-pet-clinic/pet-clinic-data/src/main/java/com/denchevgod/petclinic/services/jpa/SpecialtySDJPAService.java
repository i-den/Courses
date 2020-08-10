package com.denchevgod.petclinic.services.jpa;

import com.denchevgod.petclinic.model.Specialty;
import com.denchevgod.petclinic.repository.SpecialtyRepository;
import com.denchevgod.petclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJPAService implements SpecialtiesService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJPAService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty obj) {
        return specialtyRepository.save(obj);
    }

    @Override
    public void delete(Specialty obj) {
        specialtyRepository.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
