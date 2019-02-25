package com.example.relationship.dtos;

import lombok.*;

import java.util.Date;

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

}
