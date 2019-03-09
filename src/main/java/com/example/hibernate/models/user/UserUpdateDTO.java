package com.example.hibernate.models.user;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO extends UserProperties {

    private Long id;

}
