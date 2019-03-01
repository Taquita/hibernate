package com.example.relationship.services;

import com.example.relationship.models.order.Order;
import com.example.relationship.models.order.OrderReturnDTO;
import com.example.relationship.models.order.OrderCreateDTO;
import com.example.relationship.models.order.OrderUpdateDTO;
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

    public OrderReturnDTO create(OrderCreateDTO order) {
        Order entity = mapper.map(order, Order.class);
        return mapper.map(super.create(entity), OrderReturnDTO.class);
    }

    public OrderReturnDTO update(OrderUpdateDTO order) {
        Order entity = mapper.map(order, Order.class);
        return mapper.map(super.update(entity), OrderReturnDTO.class);
    }
}
