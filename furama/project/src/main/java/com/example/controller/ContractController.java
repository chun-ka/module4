package com.example.controller;

import com.example.dto.ContractDto;
import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IAttractFacilityService iAttractFacilityService;
    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(page = 0, value = 5) Pageable pageable) {
        Page<ContractDto> contractDtos = iContractService.showList(pageable);
        List<Contract> contractList=iContractService.showList();
        List<Customer> customers = iCustomerService.showList();
        List<Facility> facilities = iFacilityService.showList();
        List<AttachFacility> attachFacilityList = iAttractFacilityService.showList();
        int idContract= contractList.size();
        model.addAttribute("contractDtos", contractDtos);
        model.addAttribute("attachFacilityList", attachFacilityList);
        model.addAttribute("customers", customers);
        model.addAttribute("facilities", facilities);
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("idContract", idContract);

        return "/contract/list";
    }

    @PostMapping("create")
    public String create(Contract contract,String attachFacility,String quantity) {
        iContractService.save(contract);
        if (attachFacility!=null&&quantity!=null){
            ContractDetail contractDetail=new ContractDetail();
            contractDetail.setContract(iContractService.findById(contract.getId()).get());
            contractDetail.setFacilitySet(iAttractFacilityService.findById(Integer.parseInt(attachFacility)).get());
            contractDetail.setQuantity(Integer.parseInt(quantity));
            iContractDetailService.save(contractDetail);
        }
        return "redirect:/contract";
    }
    @PostMapping("contractDetail/create")
    public String create( ContractDetail contractDetail ){
        iContractDetailService.save(contractDetail);
        return "redirect:/contract";
    }
}
