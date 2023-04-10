package com.example.service.impl;

import com.example.dto.ContractDto;
import com.example.model.contract.Contract;
import com.example.reposotory.IContractRepository;
import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<ContractDto> showList(Pageable pageable) {
        return iContractRepository.showList(pageable);
    }

    @Override
    public List<Contract> showList() {
        return iContractRepository.findAll();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Contract> findById(int id) {
        return iContractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void remove(int id) {

    }
}
