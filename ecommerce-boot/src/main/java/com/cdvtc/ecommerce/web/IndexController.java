package com.cdvtc.ecommerce.web;

import com.cdvtc.ecommerce.model.Category;
import com.cdvtc.ecommerce.model.Product;
import com.cdvtc.ecommerce.repository.CategoryRepository;
import com.cdvtc.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String home(Model model, HttpSession session) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);


        List<Product> products = productService.getAllProduct();

        model.addAttribute("products", products);

        return "index";
    }

    @RequestMapping("/products/{categoryId}")
    public String products(Model model, @PathVariable Integer categoryId) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        List<Product> products = productService.getProducts(categoryId);
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("products")
    public String search(Model model, @RequestParam String s) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        List<Product> products = productService.getProducts(s);
        model.addAttribute("products", products);
        return "index";
    }
}
