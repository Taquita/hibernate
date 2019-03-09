package com.example.hibernate.services;

import com.example.hibernate.models.phone.Phone;
import com.example.hibernate.models.user.User;
import com.example.hibernate.models.user.UserCreateDTO;
import com.example.hibernate.models.user.UserReturnDTO;
import com.example.hibernate.models.user.UserUpdateDTO;
import com.example.hibernate.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends GenericService<User, Long>{

    private final UserRepository repository;
    private ModelMapper mapper;

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    public UserReturnDTO create(UserCreateDTO user) {
        User entity = mapper.map(user, User.class);
        return mapper.map(super.create(entity), UserReturnDTO.class);
    }

    public UserReturnDTO update(UserUpdateDTO user) {
        User entity = mapper.map(user, User.class);
        List<Phone> phones = super.getById(entity.getId()).getPhones();
        entity.setPhones(phones);
        return mapper.map(super.update(entity), UserReturnDTO.class);
    }

    public UserReturnDTO getOne(Long id) {
        return mapper.map(super.getById(id), UserReturnDTO.class);
    }

    public Page<UserReturnDTO> pagine(int page, int count, Sort.Direction direction, String property) {
        return super.pagination(page, count, direction, property)
                .map(user -> mapper.map(user, UserReturnDTO.class));
    }
}
