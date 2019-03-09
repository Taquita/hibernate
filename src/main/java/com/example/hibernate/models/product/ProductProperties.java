package com.example.hibernate.models.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
abstract class ProductProperties {

    @ApiModelProperty(value = "Product name", required = true, example = "SUDO Mug")
    private String name;

    @ApiModelProperty(value = "Product price", required = true, example = "1500.30")
    private BigDecimal price;

}
