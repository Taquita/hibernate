package com.example.hibernate.models.order;

import com.example.hibernate.models.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "order_seq")
    private Long id;

    @NotNull(message = "Order user can be not null")
    @Column(name = "[user]", nullable = false)
    private String user;

    @CreationTimestamp
    @Column(name = "[createdAt]", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "[updatedAt]")
    private Date updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Product> products;

}
