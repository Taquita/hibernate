package com.example.hibernate.models.order;

import com.example.hibernate.models.product.ProductReturnDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class OrderReturnDTO extends OrderProperties {

    private Long id;

    private List<ProductReturnDTO> products;

}
