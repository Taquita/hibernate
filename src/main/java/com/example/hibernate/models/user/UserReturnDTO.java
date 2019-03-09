package com.example.hibernate.models.user;

import com.example.hibernate.models.phone.PhoneCompleteDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class UserReturnDTO extends UserProperties{

    private Long id;

    private List<PhoneCompleteDTO> phones;

}
