package com.example.dto;

import com.example.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    @JsonProperty ("id")
    private Long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("age")
    private Long age;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("role")
    private User.RoleEnum role;
    @JsonProperty("password")
    private String password;
    @JsonProperty("managerId")
    private Long managerId;
    @JsonProperty("address")
    private String address;
    @JsonProperty("tag")
    private String tag;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Long getAge() {
        return age;
    }


    public void setAge(Long age) {
        this.age = age;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public User.RoleEnum getRole() {
        return role;
    }


    public void setRole(User.RoleEnum role) {
        this.role = role;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Long getManagerId() {
        return managerId;
    }


    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getTag() {
        return tag;
    }


    public void setTag(String tag) {
        this.tag = tag;
    }
}
