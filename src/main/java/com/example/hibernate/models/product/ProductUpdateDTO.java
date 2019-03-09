package com.example.hibernate.models.product;

import com.example.hibernate.models.order.OrderUpdateDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateDTO extends ProductProperties{

    private Long id;

    @JsonBackReference
    private OrderUpdateDTO order;

}
