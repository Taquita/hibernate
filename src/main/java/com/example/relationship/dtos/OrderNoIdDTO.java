package com.example.relationship.dtos;

import com.example.relationship.domains.Product;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderNoIdDTO {

    @ApiModelProperty(value = "Order user", required = true, example = "John Alex")
    private String user;

    @ApiModelProperty(value = "Order products", required = true)
    private List<ProductNoIdDTO> products;

}
