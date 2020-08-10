package com.denchevgod.petclinic.services.jpa;

import com.denchevgod.petclinic.model.Visit;
import com.denchevgod.petclinic.repository.VisitRepository;
import com.denchevgod.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJPAService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit obj) {
        return visitRepository.save(obj);
    }

    @Override
    public void delete(Visit obj) {
        visitRepository.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
