package com.example.service;

import com.example.dto.ContractDto;
import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService extends IService<Contract> {
    Page<ContractDto> showList(Pageable pageable);
    List<Contract> showList();
}
