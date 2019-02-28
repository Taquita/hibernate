package com.example.relationship.dtos;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends OrderPropertiesDTO {

    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private List<ProductDTO> products;

}
