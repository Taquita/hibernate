package com.example.hibernate.services;

import com.example.hibernate.models.phone.Phone;
import com.example.hibernate.models.phone.PhoneCreateDTO;
import com.example.hibernate.models.phone.PhoneCompleteDTO;
import com.example.hibernate.models.user.User;
import com.example.hibernate.models.user.UserReturnDTO;
import com.example.hibernate.repositories.PhoneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService extends GenericService<Phone, Long> {

    private final PhoneRepository repository;
    private final UserService userService;
    private ModelMapper mapper;

    @Autowired
    public PhoneService(PhoneRepository repository, UserService userService) {
        super(repository);
        this.repository = repository;
        this.userService = userService;
        this.mapper = new ModelMapper();
    }

    public UserReturnDTO addPhoneInUser(Long id, PhoneCreateDTO phone) {
        User user = this.userService.getById(id);
        Phone entity = super.create(mapper.map(phone, Phone.class));
        user.getPhones().add(entity);
        return mapper.map(this.userService.update(user), UserReturnDTO.class);
    }

    public PhoneCompleteDTO update(PhoneCompleteDTO phone) {
        Phone entity = mapper.map(phone, Phone.class);
        return mapper.map(super.update(entity), PhoneCompleteDTO.class);
    }

    public UserReturnDTO remove(Long id, Long phoneId) {
        User user = this.userService.getById(id);
        user.getPhones().remove(this.getById(phoneId));
        return mapper.map(this.userService.update(user), UserReturnDTO.class);
    }
}
