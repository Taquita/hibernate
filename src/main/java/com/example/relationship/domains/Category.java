package com.example.relationship.domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "[category]")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
    @SequenceGenerator(name = "category_generator", sequenceName = "category_seq")
    private Long id;

    @NotNull(message = "Category name can be not null")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Category description can be not null")
    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;

}
