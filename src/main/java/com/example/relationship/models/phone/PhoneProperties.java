package com.example.relationship.models.phone;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
abstract class PhoneProperties {

    private String ddd;

    private String number;

}
