package com.example.relationship.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "[order]")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "order_seq")
    private Long id;

    @NotNull(message = "Order user can be not null")
    @Column(name = "[user]", nullable = false)
    private String user;

    @CreationTimestamp
    @Column(name = "[createdAt]")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "[updatedAt]")
    private Date updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Product> products;
}
