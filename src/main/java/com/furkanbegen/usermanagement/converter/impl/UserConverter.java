package com.furkanbegen.usermanagement.converter.impl;


import com.furkanbegen.usermanagement.converter.Converter;
import com.furkanbegen.usermanagement.dto.UserDTO;
import com.furkanbegen.usermanagement.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDTO> {
    @Override
    public User convertToModel(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(user.getLastName());
        user.setPhoneNumber(user.getPhoneNumber());

        return user;
    }

    @Override
    public UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhoneNumber(user.getPhoneNumber());

        return userDTO;
    }
}
