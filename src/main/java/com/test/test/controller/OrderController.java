package com.test.test.controller;

import com.test.test.dto.OrderDTO;
import com.test.test.entity.Order;
import com.test.test.entity.User;
import com.test.test.mappers.OrderDTOMapper;
import com.test.test.repository.OrderRepository;
import com.test.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderDTOMapper orderDTOMapper;

    @Autowired
    public OrderController(OrderRepository userRepository, UserRepository userRepository1, OrderDTOMapper orderDTOMapper) {
        this.orderRepository = userRepository;
        this.userRepository = userRepository1;
        this.orderDTOMapper = orderDTOMapper;
    }

    @GetMapping("/all")
    public List<OrderDTO> getSOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderDTOMapper)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createOrder(@RequestBody Order order, @RequestParam("userId") Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        order.setUser(user);
        orderRepository.save(order);
    }

}
