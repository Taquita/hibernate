package com.example.relationship.services;

import com.example.relationship.domains.Order;
import com.example.relationship.dtos.OrderNoIdDTO;
import com.example.relationship.mappers.ProductMapper;
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

    public Order create(OrderNoIdDTO order) {
        ModelMapper mapped = ProductMapper.convert(mapper);
        Order entity = mapped.map(order, Order.class);
        return super.create(entity);
    }
}
