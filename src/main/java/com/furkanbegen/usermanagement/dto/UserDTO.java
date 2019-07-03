package com.furkanbegen.usermanagement.dto;

import javax.validation.constraints.NotEmpty;

public class UserDTO {

    private String id;
    @NotEmpty(message = "İsim boş olamaz")
    private String firstName;
    @NotEmpty(message = "Soyisim boş olamaz")
    private String lastName;
    @NotEmpty(message = "Telefon numarası boş olamaz")
    private String phoneNumber;

    public UserDTO() {
    }

    public UserDTO(String id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
