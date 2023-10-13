package com.felipe.dscommerce.services;

import com.felipe.dscommerce.dto.OrderDTO;
import com.felipe.dscommerce.dto.ProductDTO;
import com.felipe.dscommerce.entities.Order;
import com.felipe.dscommerce.entities.Product;
import com.felipe.dscommerce.repositories.OrderRepository;
import com.felipe.dscommerce.repositories.ProductRepository;
import com.felipe.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true) // --> realiza uma operacao somente de leitura
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
