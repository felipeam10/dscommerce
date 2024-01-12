package com.felipe.dscommerce.services;

import com.felipe.dscommerce.dto.OrderDTO;
import com.felipe.dscommerce.entities.Order;
import com.felipe.dscommerce.entities.User;
import com.felipe.dscommerce.repositories.OrderRepository;
import com.felipe.dscommerce.tests.OrderFactory;
import com.felipe.dscommerce.tests.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class OrderServiceTests {

    @InjectMocks
    private OrderService service;
    @Mock
    private OrderRepository repository;
    @Mock
    private AuthService authService;

    private long existingOrderId;
    private long nonExistingOrderId;
    private Order order;
    private OrderDTO orderDTO;
    private User admin;
    private User client;
    @BeforeEach
    public void setUp() throws Exception {
        existingOrderId = 1L;
        nonExistingOrderId = 2L;
        admin = UserFactory.createCustomAdminUser(1L, "Alex");
        client = UserFactory.createCustomClientUser(2L, "Bob");

        order = OrderFactory.createOrder(client);
        orderDTO = new OrderDTO(order);

        Mockito.when(repository.findById(existingOrderId)).thenReturn(Optional.of(order));
        Mockito.when(repository.findById(nonExistingOrderId)).thenReturn(Optional.empty());
    }



}
