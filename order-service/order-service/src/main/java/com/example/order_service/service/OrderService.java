package com.example.order_service.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.order_service.client.BookClient;
import com.example.order_service.dto.BookDTO;
import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;


@Service
public class OrderService {

    private final OrderRepository repo;
    private final BookClient bookClient;

    public OrderService(OrderRepository repo, BookClient bookClient) {
        this.repo = repo;
        this.bookClient = bookClient;
    }

    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    public Order getOrderById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Order placeOrder(Order order) {

        BookDTO book = bookClient.getBookById(order.getBookId());

        double total = book.getPrice() * order.getQuantity();

        order.setTotalPrice(total);
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        return repo.save(order);
    }

    public Order updateStatus(Long id, Order order) {

        Order existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setStatus(order.getStatus());
            return repo.save(existing);
        }

        return null;
    }

    public void deleteOrder(Long id) {
        repo.deleteById(id);
    }
}