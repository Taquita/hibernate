package com.example.hibernate.models.phone;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PhoneCreateDTO extends PhoneProperties{

    @ApiModelProperty(value = "Direct Dialing Distance", required = true, example = "092")
    private String ddd;

    @ApiModelProperty(value = "Phone Number", required = true, example = "992487425")
    private String number;

}
