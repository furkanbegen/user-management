package com.furkanbegen.usermanagement.service;

import com.furkanbegen.usermanagement.converter.impl.UserConverter;
import com.furkanbegen.usermanagement.dto.UserDTO;
import com.furkanbegen.usermanagement.model.User;
import com.furkanbegen.usermanagement.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserConverter userConverter;

    private User userForRequest, userForResponse;
    private UserDTO userDTOForRequest, userDTOForResponse;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        userForRequest = new User();
        userForRequest.setId("5d1cfbf3b494e10cc4817260");
        userForRequest.setFirstName("Furkan");
        userForRequest.setLastName("Begen");
        userForRequest.setPhoneNumber("02122121212");


        userDTOForRequest = new UserDTO();
        userDTOForRequest.setId("5d1cfbf3b494e10cc4817260");
        userDTOForRequest.setFirstName("Furkan");
        userDTOForRequest.setLastName("Begen");
        userDTOForRequest.setPhoneNumber("02122121212");

        userForResponse = new User();
        userForResponse.setId("5d1cfbf3b494e10cc4817260");
        userForResponse.setFirstName("Furkan");
        userForResponse.setLastName("Begen");
        userForResponse.setPhoneNumber("02122121212");

        userDTOForResponse = new UserDTO();
        userDTOForResponse.setId("5d1cfbf3b494e10cc4817260");
        userDTOForResponse.setFirstName("Furkan");
        userDTOForResponse.setLastName("Begen");
        userDTOForResponse.setPhoneNumber("02122121212");
    }

    @Test
    public void should_create_new_user(){
        //given
        given(userRepository.insert(userForRequest)).willReturn(userForResponse);
        given(userConverter.convertToModel(userDTOForRequest)).willReturn(userForRequest);
        given(userConverter.convertToDto(userForResponse)).willReturn(userDTOForResponse);

        //when
        UserDTO user = userService.createUser(userDTOForRequest);

        //then
        then(user).isEqualToComparingFieldByField(userDTOForResponse);
    }

    @Test
    public void should_get_user_by_id(){
        //given
        given(userRepository.findById(userForRequest.getId())).willReturn(java.util.Optional.ofNullable(userForResponse));
        given(userConverter.convertToDto(userForResponse)).willReturn(userDTOForResponse);

        //when
        UserDTO user = userService.readUser("5d1cfbf3b494e10cc4817260");

        //then
        then(user).isEqualToComparingFieldByField(userDTOForResponse);
    }

    @Test
    public void should_update_given_user(){
        //given
        given(userRepository.insert(userForRequest)).willReturn(userForResponse);
        given(userConverter.convertToModel(userDTOForRequest)).willReturn(userForRequest);
        given(userConverter.convertToDto(userForResponse)).willReturn(userDTOForResponse);

        //when
        UserDTO user = userService.createUser(userDTOForRequest);

        //then
        then(user).isEqualToComparingFieldByField(userDTOForResponse);
    }
}
