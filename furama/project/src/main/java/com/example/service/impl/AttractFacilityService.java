package com.example.service.impl;

import com.example.model.contract.AttachFacility;
import com.example.reposotory.IAttachFacilityRepository;
import com.example.service.IAttractFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttractFacilityService implements IAttractFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public List<AttachFacility> showList() {
        return iAttachFacilityRepository.findAll();
    }

    @Override
    public Page<AttachFacility> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<AttachFacility> findById(int id) {
        return iAttachFacilityRepository.findById(id);
    }

    @Override
    public void save(AttachFacility attachFacility) {

    }

    @Override
    public void remove(int id) {

    }
}
