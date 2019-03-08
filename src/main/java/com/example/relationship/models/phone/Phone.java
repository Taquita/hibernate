package com.example.relationship.models.phone;

import com.example.relationship.models.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "[phone]")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_generator")
    @SequenceGenerator(name = "phone_generator", sequenceName = "phone_seq")
    private Long id;

    @Column(name = "[DDD]", nullable = false, length = 3)
    private String DDD;

    @Column(name = "[number]", nullable = false, length = 9)
    private String number;

    @ManyToMany(mappedBy = "phones")
    private List<User> users;

}
