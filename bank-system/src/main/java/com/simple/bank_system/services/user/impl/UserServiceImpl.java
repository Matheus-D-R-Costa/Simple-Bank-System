package com.simple.bank_system.services.user.impl;

import com.simple.bank_system.dtos.user.UserDto;
import com.simple.bank_system.models.user.UserModel;
import com.simple.bank_system.repositories.user.UserRepository;
import com.simple.bank_system.services.user.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + id));
    }

    @Override
    public UserModel create(UserDto userDto) {
        if (userRepository.existsById(userDto.id())) {
            throw new IllegalArgumentException("This User ID already exists.");
        }

        UserModel userModel = userDto.toModel();
        return userRepository.save(userModel);
    }

    @Override
    public UserModel update(Integer id, UserDto userDto) {
        if (findById(id) != userDto.toModel()) throw new IllegalArgumentException("This User ID does not exist.");
        UserModel userModel = userDto.toModel();
        return userRepository.save(userModel);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("This User ID does not exist.");
        }
        userRepository.deleteById(id);
    }
}
