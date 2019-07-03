package com.furkanbegen.usermanagement.service;

import com.furkanbegen.usermanagement.converter.impl.UserConverter;
import com.furkanbegen.usermanagement.dto.UserDTO;
import com.furkanbegen.usermanagement.exception.UserNotFoundException;
import com.furkanbegen.usermanagement.model.User;
import com.furkanbegen.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    public UserDTO createUser(UserDTO user){
        User userModel = userConverter.convertToModel(user);
        User createdUser = userRepository.insert(userModel);

        UserDTO result = userConverter.convertToDto(createdUser);
        return result;
    }


    public UserDTO readUser(String id){
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent())
            throw new UserNotFoundException();

        UserDTO result = userConverter.convertToDto(user.get());

        return result;
    }


    public UserDTO updateUser(String id, UserDTO user){
        Optional<User> currentUser = userRepository.findById(id);

        if (!currentUser.isPresent())
            throw new UserNotFoundException();

        currentUser.get().setFirstName(user.getFirstName());
        currentUser.get().setLastName(user.getLastName());
        currentUser.get().setPhoneNumber(user.getPhoneNumber());

        User updateUser = userRepository.save(currentUser.get());

        UserDTO result = userConverter.convertToDto(updateUser);

        return result;
    }

    public void deleteUser(String id){
        Optional<User> currentUser = userRepository.findById(id);

        if (!currentUser.isPresent())
            throw new UserNotFoundException();

        userRepository.delete(currentUser.get());
    }

    public List<UserDTO> getAllUsers(){
        List<User> allUsers = userRepository.findAll();

        List<UserDTO> result = new ArrayList<>();

        allUsers.forEach(x -> result.add(userConverter.convertToDto(x)));


        return result;
    }

}
