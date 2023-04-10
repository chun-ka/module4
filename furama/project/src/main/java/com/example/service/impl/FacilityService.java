package com.example.service.impl;

import com.example.model.facility.Facility;
import com.example.reposotory.IFacilityRepository;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return iFacilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> search(String name, String facilityTypeId, Pageable pageable) {
        return iFacilityRepository.search(name,facilityTypeId,pageable);
    }

    @Override
    public List<Facility> showList() {
        return iFacilityRepository.findAll();
    }
}
