package com.example.relationship.services;

import com.example.relationship.domains.Order;
import com.example.relationship.dtos.OrderNoIdDTO;
import com.example.relationship.mappers.OrderMapper;
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
//        ModelMapper mapped = OrderMapper.convert(mapper);
        Order entity = mapper.map(order, Order.class);
        return super.create(entity);
    }
}
