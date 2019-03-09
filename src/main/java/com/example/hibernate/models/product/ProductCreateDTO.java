package com.example.hibernate.models.product;

import com.example.hibernate.models.order.OrderCreateDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDTO extends ProductProperties{

    @JsonBackReference
    private OrderCreateDTO order;

}
