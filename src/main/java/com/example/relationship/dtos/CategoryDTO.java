package com.example.relationship.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDTO extends CategoryNoIdDTO{

    private Long id;

}
