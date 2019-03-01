package com.example.relationship.models.book;

import com.example.relationship.models.category.CategoryDTO;
import com.example.relationship.models.category.Category;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter()
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class BookDTO extends BookNoIdDTO {

    private Long id;

    private CategoryDTO category;

    public void setCategory(Category category) {
        ModelMapper mapper = new ModelMapper();
        this.setCategory(mapper.map(category, CategoryDTO.class));
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

}
