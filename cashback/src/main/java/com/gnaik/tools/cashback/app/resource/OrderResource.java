package com.gnaik.tools.cashback.app.resource;

import com.gnaik.tools.cashback.app.documents.Order;
import com.gnaik.tools.cashback.app.repository.OrderRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gshop/{id}/order")
public class OrderResource {

    private OrderRepository orderRepository;

    public OrderResource(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    @PutMapping("/{id}")
    public void cancelOrder(@PathVariable Long id) {
        Order order = getOrderById(id);
        if(order != null) {
            orderRepository.delete(order);
        }
    }
}
