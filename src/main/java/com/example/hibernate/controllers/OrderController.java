package com.example.hibernate.controllers;

import com.example.hibernate.models.order.OrderReturnDTO;
import com.example.hibernate.models.order.OrderCreateDTO;
import com.example.hibernate.models.order.OrderUpdateDTO;
import com.example.hibernate.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "OrderCotnroller", description = "Order endpoints")
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Creation Order")
    public ResponseEntity<OrderReturnDTO> createOrder(
            @ApiParam(value = "Order Entity", required = true)
            @RequestBody OrderCreateDTO order
    ) {
        OrderReturnDTO entity = this.service.create(order);
        return new ResponseEntity<OrderReturnDTO>(entity, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Update Order")
    public ResponseEntity<OrderReturnDTO> updateOrder(
            @ApiParam(value = "Order Entity", required = true)
            @RequestBody OrderUpdateDTO order
    ) {
        OrderReturnDTO entity = this.service.update(order);
        return new ResponseEntity<OrderReturnDTO>(entity, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Remove Order by ID")
    public void removeOrder(
            @ApiParam(value = "Order ID", required = true)
            @PathVariable Long id
    ) {
        this.service.remove(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Order by ID")
    public ResponseEntity<OrderReturnDTO> getOrderById(
            @ApiParam(value = "Order ID", required = true)
            @PathVariable Long id
    ) {
        OrderReturnDTO entity = this.service.findById(id);
        return new ResponseEntity<OrderReturnDTO>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Order with Pagination")
    public Page<OrderReturnDTO> getOrderPagination(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "count", defaultValue = "10") int count,
            @RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(value = "property", defaultValue = "id") String property
    ) {
        return this.service.pagine(page, count, direction, property);
    }

}
