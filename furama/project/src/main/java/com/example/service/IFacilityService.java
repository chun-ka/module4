package com.example.service;

import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityService extends IService<Facility> {
    Page<Facility> search( String name, String facilityTypeId, Pageable pageable);
    List<Facility> showList();

}
