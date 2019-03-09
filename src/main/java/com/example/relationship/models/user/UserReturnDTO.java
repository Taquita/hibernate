package com.example.relationship.models.user;

import com.example.relationship.models.phone.PhoneCompleteDTO;
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
