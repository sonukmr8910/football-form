package com.form.footballform.models;

import java.util.List;

public class User {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Address address;
    private List<Team> desiredTeams;
    private List<Position> desiredPositions;

    public User() {
    }

    public User(Long id, String userName, String firstName, String lastName, String phoneNumber, String email, Address address, List<Team> desiredTeams, List<Position> desiredPositions) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.desiredTeams = desiredTeams;
        this.desiredPositions = desiredPositions;
    }

    public User(String userName, String firstName, String lastName, String phoneNumber, String email, Address address, List<Team> desiredTeams, List<Position> desiredPositions) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.desiredTeams = desiredTeams;
        this.desiredPositions = desiredPositions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Team> getDesiredTeams() {
        return desiredTeams;
    }

    public void setDesiredTeams(List<Team> desiredTeams) {
        this.desiredTeams = desiredTeams;
    }

    public List<Position> getDesiredPositions() {
        return desiredPositions;
    }

    public void setDesiredPositions(List<Position> desiredPositions) {
        this.desiredPositions = desiredPositions;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", desiredTeams=" + desiredTeams +
                ", desiredPositions=" + desiredPositions +
                '}';
    }
}
