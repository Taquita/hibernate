package com.example.relationship.controllers;

import com.example.relationship.domains.Order;
import com.example.relationship.dtos.OrderDTO;
import com.example.relationship.dtos.OrderNoIdDTO;
import com.example.relationship.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Order> createOrder(
            @ApiParam(value = "Order Entity", required = true)
            @RequestBody OrderNoIdDTO order
            ) {
        Order entity = this.service.create(order);
        return new ResponseEntity<Order>(entity, HttpStatus.OK);
    }

}
