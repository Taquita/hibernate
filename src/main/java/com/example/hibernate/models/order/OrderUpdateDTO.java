package com.example.hibernate.models.order;

import com.example.hibernate.models.product.ProductUpdateDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateDTO extends OrderProperties {

    private Long id;

    @JsonManagedReference
    private List<ProductUpdateDTO> products;

}
