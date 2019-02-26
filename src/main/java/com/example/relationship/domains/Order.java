package com.example.relationship.domains;

import com.example.relationship.dtos.ProductNoIdDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.reflect.Type;
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
    @Column(name = "[createdAt]")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "[updatedAt]")
    private Date updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Product> products;

    public void setProducts(List<ProductNoIdDTO> products) {
        ModelMapper mapper = new ModelMapper();
        Type target = new TypeToken<List<Product>>() {}.getType();
        List<Product> productList = mapper.map(products, target);
        this.setProducts(productList);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
