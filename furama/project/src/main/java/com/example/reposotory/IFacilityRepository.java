package com.example.reposotory;

import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select * from facility  where name like concat('%',:name,'%')  and facility_type_id like concat ('%',:facilityTypeId,'%') "
            , nativeQuery = true)
    Page<Facility> search(@Param("name") String name, @Param("facilityTypeId") String facilityTypeId, Pageable pageable);

}
