package com.furkanbegen.usermanagement.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author furkanbegen
 * createn at 30/06/2019
 * on project user-management
 */
public class UserTest {

    @Test
    public void userTest(){
        User user = new User("5d1887e97998741835a2102b", "Furkan", "Begen", "05342200095");

        assertEquals("5d1887e97998741835a2102b", user.getId());
        assertEquals("Furkan", user.getFirstName());
        assertEquals("Begen", user.getLastName());
        assertEquals("05342200095", user.getPhoneNumber());
    }
}
