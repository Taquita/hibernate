package com.example.hibernate.models.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO extends UserProperties{

    @ApiModelProperty(value = "User name", required = true, example = "John Deep")
    private String name;

}
