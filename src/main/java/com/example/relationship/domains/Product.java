package com.example.relationship.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "[product]")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_seq")
    private Long id;

    @NotNull(message = "Product name can be not null")
    @Column(name = "[name]", nullable = false)
    private String name;

    @NotNull(message = "Product price can be not null")
    @Column(name = "[price]", nullable = false)
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "[order]")
    @JsonBackReference
    private Order order;

    @CreationTimestamp
    @Column(name = "[createdAt]", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "[updatedAt]", nullable = false)
    private Date updatedAt;

}
