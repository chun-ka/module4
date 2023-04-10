package com.example.service;

import com.example.model.contract.AttachFacility;

import java.util.List;

public interface IAttractFacilityService extends IService<AttachFacility> {
    List<AttachFacility> showList();
}
