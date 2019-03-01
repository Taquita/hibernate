package com.example.relationship.models.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
abstract class OrderProperties {

    @ApiModelProperty(value = "Order user", required = true, example = "John Alex")
    private String user;

}
