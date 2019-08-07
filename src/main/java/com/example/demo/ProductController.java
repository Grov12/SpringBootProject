package com.example.demo;

import com.example.demo.Service.Imp.ShoppingCartServiceImp;
import com.example.demo.Service.ProductService;
import com.example.demo.com.example.demo.Product;
import com.example.demo.dao.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductService productService;
    private final ShoppingCartServiceImp shoppingCartService;

    @Autowired
    public ProductController(ShoppingCartServiceImp shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;

    }


    @GetMapping("/products/category/{name}")
    public ModelAndView productSubCategory(@PathVariable("name") String name){
        ModelAndView mv = new ModelAndView("/products");
        List<Product> listSubCategory = productService.findBySubCategory(name);
        mv.addObject("products",listSubCategory);

        return mv;

    }


    @GetMapping("/products/buy/{name}")
    public ModelAndView addProduct(@PathVariable("name") String name) {

       productService.findByName(name).ifPresent(shoppingCartService::addToList);





        return itemDetail(name);


    }


    @GetMapping("/products/remove/{name}")
    public ModelAndView removeProduct(@PathVariable("name") String name) {

        productService.findByName(name).ifPresent(shoppingCartService::removeFromList);

        return itemDetail(name);


    }


    @GetMapping("/shoppingcart")
    public ModelAndView getProducts() {
        ModelAndView mv = new ModelAndView("/shoppingcart");
        Map<Product,Integer> list = shoppingCartService.getAllFromList();
        BigDecimal price = shoppingCartService.getTotalPrice();

        mv.addObject("products",list);
        mv.addObject("totalprice", price);

        return mv;
    }


    @GetMapping("/itemdetail/{name}")
    public ModelAndView itemDetail(@PathVariable("name") String name) {
        ModelAndView mv = new ModelAndView("/itemdetail");
       Optional<Product> product = productService.findByName(name);
       mv.addObject("product",product);
        return mv;
    }


}
