package com.example.reposotory;

import com.example.dto.ContractDto;
import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "SELECT ct.id as id,ifnull(group_concat(af.name),'Chưa thêm dịch vụ đi kèm') as attachFacilityName, ct.start_date as startDate, ct.end_date as endDate, ct.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue,employee.name as employeeName FROM contract ct left join employee on ct.employee_id = employee.id LEFT JOIN contract_detail cd ON ct.id = cd.contract_id LEFT JOIN attach_facility af ON cd.facility_set_id = af.id LEFT JOIN facility f ON ct.facility_id = f.id join customer as cus on ct.customer_id = cus.id GROUP BY ct.id ORDER BY ct.id",
    countQuery = "SELECT ct.id as id,group_concat(af.name) as attachFacilityName, ct.start_date as startDate, ct.end_date as endDate, ct.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue,employee.name as employeeName FROM contract ct left join employee on ct.employee_id = employee.id LEFT JOIN contract_detail cd ON ct.id = cd.contract_id LEFT JOIN attach_facility af ON cd.facility_set_id = af.id LEFT JOIN facility f ON ct.facility_id = f.id join customer as cus on ct.customer_id = cus.id GROUP BY ct.id ORDER BY ct.id",
    nativeQuery = true)
    Page<ContractDto> showList(Pageable pageable);
}
