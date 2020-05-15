package com.neu.product_service.controller;

import com.neu.product_service.domain.Product;
import com.neu.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("{id}")
    @ResponseBody
    public Product findById(@PathVariable("id") Integer productId){
        return productService.findById(productId);
    }
}
