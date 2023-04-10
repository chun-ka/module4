package com.example.controller;

import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.service.IFacilityService;
import com.example.service.IFacilityTypeService;
import com.example.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @GetMapping("")
//    public String showList(Model model, Pageable pageable){
//        Page<Facility> facilityList=iFacilityService.findAll(pageable);
//        List<FacilityType> facilityTypeList=iFacilityTypeService.findAll();
//        List<RentType> rentTypeList=iRentTypeService.findAll();
//        model.addAttribute("facilityList",facilityList);
//        model.addAttribute("facilityTypeList",facilityTypeList);
//        model.addAttribute("rentTypeList",rentTypeList);
//        return "facility/list";
//    }
    public String showListBySearch(Model model, @PageableDefault(page = 0,value = 5)Pageable pageable, @RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "")String facilityType){
        Page<Facility> facilityList=iFacilityService.search(name,facilityType,pageable);
        List<FacilityType> facilityTypeList=iFacilityTypeService.findAll();
        model.addAttribute("facilityList",facilityList);
        model.addAttribute("facilityTypeList",facilityTypeList);
        model.addAttribute("name",name);
        if (!facilityType.equals("")) {
            model.addAttribute("facilityTypeId", Integer.parseInt(facilityType));
        }
        return "facility/list";
    }

    @PostMapping("/delete")
    public String delete(int deleteId, RedirectAttributes redirectAttributes){
        iFacilityService.remove(deleteId);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/facility";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("facility",new Facility());
        List<FacilityType> facilityTypeList=iFacilityTypeService.findAll();
        List<RentType> rentTypeList=iRentTypeService.findAll();
        model.addAttribute("facilityTypeList",facilityTypeList);
        model.addAttribute("rentTypeList",rentTypeList);
        return "facility/create";
    }
    @PostMapping("/create")
    public String create(Facility facility,RedirectAttributes redirectAttributes){
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Thêm thành công");
        return "redirect:/facility";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        List<FacilityType> facilityTypeList=iFacilityTypeService.findAll();
        List<RentType> rentTypeList=iRentTypeService.findAll();
        model.addAttribute("rentTypeList",rentTypeList);
        model.addAttribute("facilityTypeList",facilityTypeList);
        Facility facility=iFacilityService.findById(id).get();
        model.addAttribute("facility",facility);

        return "facility/edit";
    }
    @PostMapping("/edit")
    public String edit(Facility facility,RedirectAttributes redirectAttributes){
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Sửa thành công");
        return "redirect:/facility";
    }
}
