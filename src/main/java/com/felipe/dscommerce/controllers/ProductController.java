package com.felipe.dscommerce.controllers;

import com.felipe.dscommerce.dto.ProductDTO;
import com.felipe.dscommerce.entities.Product;
import com.felipe.dscommerce.repositories.ProductRepository;
import com.felipe.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;
    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) { // ---> configura o parametro de rota
        return service.findById(id);
    }



}
