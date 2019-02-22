package com.example.relationship.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class BookDTO extends BookNoIdDTO {

    private Long id;

}
