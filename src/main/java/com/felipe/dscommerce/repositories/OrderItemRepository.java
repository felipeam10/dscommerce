package com.felipe.dscommerce.repositories;

import com.felipe.dscommerce.entities.Order;
import com.felipe.dscommerce.entities.OrderItem;
import com.felipe.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
