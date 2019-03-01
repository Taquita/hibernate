package com.example.relationship.models.book;

import com.example.relationship.models.category.CategoryNoIdDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookNoIdDTO {

    @ApiModelProperty(value = "Book name", required = true, example = "Wolf Boy")
    private String name;

    @ApiModelProperty(value = "Book description", required = true,
            example = "History with boy created for wolfs")
    private String description;

    private CategoryNoIdDTO category;

}
