package com.example.hibernate.models.phone;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PhoneCompleteDTO extends PhoneProperties {

    private Long id;

}
