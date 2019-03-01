package com.example.relationship.models.book;

import com.example.relationship.models.category.CategoryNoIdDTO;
import com.example.relationship.models.category.Category;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.modelmapper.ModelMapper;

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
    @JsonManagedReference
    private Category category;

    public void setCategory(CategoryNoIdDTO categoryNoIdDTO) {
        ModelMapper mapper = new ModelMapper();
        this.setCategory(mapper.map(categoryNoIdDTO, Category.class));
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
