package com.example.crudtellbook.service;

import com.example.crudtellbook.entity.UserEntity;
import com.example.crudtellbook.model.UserDto;
import com.example.crudtellbook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserDto createUser(UserDto dto) {

        UserEntity userEntity = userRepository.save(modelMapper.map(dto,UserEntity.class));

        return modelMapper.map(userEntity,UserDto.class);

    }


    public UserDto updateUser(UserDto dto) {
        boolean result = userRepository.existsById(dto.getId());
        if (!result) {
            log.warn("Error :{}", dto.getId());
            throw new RuntimeException("ERROR");
        }

        return this.createUser(dto);
    }

    public boolean deleteUser(Integer id) {
        userRepository.deleteById(id);

        Optional<UserEntity> user = userRepository.findById(id);

        return !user.isPresent();
    }


    public UserDto getUserById(Integer id) {
        Optional<UserEntity> optional = userRepository.findById(id);
        return optional.map(item -> modelMapper.map(item, UserDto.class))
                .orElse(null);
    }

    public List<UserDto> getUsers() {
        List<UserEntity> entities = userRepository.findAll();
        return entities.stream()
                .map(item -> modelMapper.map(item, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto getUserByPhoneNumber(String phoneNumber) {
        Optional<UserEntity> optional = userRepository.findByPhoneNumber(phoneNumber);
        return optional.map(item -> modelMapper.map(item, UserDto.class))
                .orElse(null);
    }

    public boolean deleteUserByPhoneNumber(String phoneNumber) {
        Optional<UserEntity> user = userRepository.deleteByPhoneNumber(phoneNumber);
        return !user.isPresent();
    }
    }

