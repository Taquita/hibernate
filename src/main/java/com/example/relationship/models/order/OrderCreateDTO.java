package com.example.relationship.models.order;

import com.example.relationship.models.product.ProductCreateDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDTO extends OrderProperties {

    @ApiModelProperty(value = "Order products", required = true)
    @JsonManagedReference
    private List<ProductCreateDTO> products;

}
