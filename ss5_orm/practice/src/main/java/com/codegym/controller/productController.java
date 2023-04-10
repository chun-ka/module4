package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class productController {

//    static {
//        try {
//            SessionFactory sessionFactory = new Configuration()
//                    .configure("hibernate.conf.xml")
//                    .buildSessionFactory();
//            sessionFactory.close();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//    }

    @Autowired
    private IProductService iProductService;
    @GetMapping("")
    public String index(Model model){
        List<Product> productList= iProductService.findAll();
        model.addAttribute("productList",productList);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("mess","thêm thành công");
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes){
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("mess","sửa thành công");
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String remove(Product product, RedirectAttributes redirectAttributes){
        iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("mess","xóa thành công");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }
    @PostMapping("/search")
    public String search(String search,Model model){
       // List<Product> productList=search==""?iProductService.findAll():iProductService.search(search);
        List<Product> productList=iProductService.search(search);
        model.addAttribute("productList",productList);
        model.addAttribute("search",search);
        return "list";
    }
}
