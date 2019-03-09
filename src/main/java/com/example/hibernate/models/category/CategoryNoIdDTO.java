package com.example.hibernate.models.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CategoryNoIdDTO {

    @ApiModelProperty(value = "Category name", required = true, example = "Romance")
    private String name;

    @ApiModelProperty(value = "Category description", required = true,
            example = "Category for couples")
    private String description;

}
