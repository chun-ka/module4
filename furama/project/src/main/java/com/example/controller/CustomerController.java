package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;
//    @GetMapping("")
//    public String showList(@PageableDefault(page = 0,value = 5) Pageable pageable, Model model){
//        Page<Customer> customerList=iCustomerService.findAll(pageable);
//        model.addAttribute("customerList",customerList);
//        return "customer/list";
//    }
    @GetMapping("")
    public String getListBySearch(@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "") String email,
                                  @RequestParam(defaultValue = "") String customerTypeId,@PageableDefault(page = 0,value = 5) Pageable pageable, Model model){
        Page<Customer> customerList=iCustomerService.search(name,email,customerTypeId,pageable);
        List<CustomerType> customerTypeList=iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList",customerTypeList);
        model.addAttribute("customerList",customerList);

        model.addAttribute("name",name);
        model.addAttribute("email",email);
        model.addAttribute("customerTypeId",customerTypeId);
        return "customer/list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        List<CustomerType> customerTypeList=iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList",customerTypeList);
        return "customer/create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
            return "customer/create";
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","thêm thành công");
        return "redirect:/customer";
    }
    @PostMapping("/delete")
    public String delete(int deleteId,RedirectAttributes redirectAttributes){
        iCustomerService.remove(deleteId);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/customer";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        Customer customer=iCustomerService.findById(id).get();
        CustomerDto customerDto=new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        List<CustomerType> customerTypeList=iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList",customerTypeList);
        return "customer/edit";
    }
    @PostMapping("/edit")
    public String edit(CustomerDto customerDto,RedirectAttributes redirectAttributes){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Sửa thành công");
        return "redirect:/customer";
    }
}
