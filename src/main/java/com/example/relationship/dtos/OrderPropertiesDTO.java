package com.example.relationship.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
abstract class OrderPropertiesDTO {

    @ApiModelProperty(value = "Order user", required = true, example = "John Alex")
    private String user;

}
