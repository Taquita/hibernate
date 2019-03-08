package com.example.relationship.services;

import com.example.relationship.models.order.Order;
import com.example.relationship.models.order.OrderReturnDTO;
import com.example.relationship.models.order.OrderCreateDTO;
import com.example.relationship.models.order.OrderUpdateDTO;
import com.example.relationship.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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

    public OrderReturnDTO findById(Long id) {
        return mapper.map(super.getById(id), OrderReturnDTO.class);
    }

    public Page<OrderReturnDTO> pagine(int page, int count, Sort.Direction direction, String property) {
        return super.pagination(page, count, direction, property)
                .map(order -> mapper.map(order, OrderReturnDTO.class));
    }

}
