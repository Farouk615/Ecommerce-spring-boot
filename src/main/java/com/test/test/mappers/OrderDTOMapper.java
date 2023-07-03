package com.test.test.mappers;

import com.test.test.dto.OrderDTO;
import com.test.test.entity.Order;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderDTOMapper implements Function<Order, OrderDTO> {

    @Override
    public OrderDTO apply(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getOname(),
                order.getUser()
        );
    }
}
