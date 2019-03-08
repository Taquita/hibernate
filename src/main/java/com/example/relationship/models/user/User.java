package com.example.relationship.models.user;

import com.example.relationship.models.phone.Phone;
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
@Table(name = "[user]")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq")
    private Long id;

    @NotNull(message = "User name can be not null")
    @Column(name = "[name]", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "[user_phone]",
            joinColumns = { @JoinColumn(name = "[user]") },
            inverseJoinColumns = { @JoinColumn(name = "[phone]") })
    private List<Phone> phones;

}
