package com.example.relationship.dtos;

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
public class OrderNoIdDTO extends OrderPropertiesDTO {

    @ApiModelProperty(value = "Order products", required = true)
    @JsonManagedReference
    private List<ProductNoIdDTO> products;

}
