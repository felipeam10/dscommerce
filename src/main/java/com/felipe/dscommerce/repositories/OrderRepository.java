package com.felipe.dscommerce.repositories;

import com.felipe.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
