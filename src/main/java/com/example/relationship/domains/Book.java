package com.example.relationship.domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_seq")
    private Long id;

    @NotNull(message = "Book name can be not null")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Book description can be not null")
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category", nullable = false)
    @NotNull(message = "Book category can be not null")
    private Category category;
}
