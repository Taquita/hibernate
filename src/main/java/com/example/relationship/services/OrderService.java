package com.example.relationship.services;

import com.example.relationship.domains.Order;
import com.example.relationship.dtos.OrderDTO;
import com.example.relationship.dtos.OrderNoIdDTO;
import com.example.relationship.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends GenericService<Order, Long> {

    private final OrderRepository repository;
    private ModelMapper mapper;

    public OrderService(OrderRepository repository) {
        super(repository);
        this.repository= repository;
        this.mapper = new ModelMapper();
    }

    public OrderDTO create(OrderNoIdDTO order) {
        Order entity = mapper.map(order, Order.class);
        Order newOrder = super.create(entity);
        return mapper.map(newOrder, OrderDTO.class);
    }
}
