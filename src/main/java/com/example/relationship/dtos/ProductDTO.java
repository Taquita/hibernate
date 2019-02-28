package com.example.relationship.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends ProductNoIdDTO {

    private Long id;

    private Date createdAt;

    private Date updatedAt;

    @JsonIgnore
    private OrderNoIdDTO order;
}
