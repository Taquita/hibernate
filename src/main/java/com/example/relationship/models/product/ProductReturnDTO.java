package com.example.relationship.models.product;

import com.example.relationship.models.order.OrderCreateDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ProductReturnDTO extends ProductProperties {

    private Long id;

    @JsonIgnore
    private OrderCreateDTO order;
}
