package com.felipe.dscommerce.controllers;

import com.felipe.dscommerce.dto.ProductDTO;
import com.felipe.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

//    URL test: http://localhost:8080/products/3
    @Autowired
    private ProductService service;
    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) { // ---> configura o parametro de rota
        return service.findById(id);
    }


//    URL test: http://localhost:8080/products?size=12&page=0&sort=name,desc
    @GetMapping()
    public Page<ProductDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping()
    public ProductDTO insert(@RequestBody ProductDTO dto) {
        return service.insert(dto);
    }

}
