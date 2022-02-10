package com.form.footballform.models.request;

import java.util.List;

public class PlayerRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private int city;
    private int state;
    private int country;
    private int pinCode;
    private int desiredTeam;
    private List<Integer> desiredPositions;

    public PlayerRequest() {
    }

    public PlayerRequest(String userName, String firstName, String lastName, String phoneNumber, String email, String address, int city, int state, int country, int pinCode, int desiredTeam, List<Integer> desiredPositions) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.desiredTeam = desiredTeam;
        this.desiredPositions = desiredPositions;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getDesiredTeam() {
        return desiredTeam;
    }

    public void setDesiredTeam(int desiredTeam) {
        this.desiredTeam = desiredTeam;
    }

    public List<Integer> getDesiredPositions() {
        return desiredPositions;
    }

    public void setDesiredPositions(List<Integer> desiredPositions) {
        this.desiredPositions = desiredPositions;
    }

    @Override
    public String toString() {
        return "FootballRequest{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pinCode=" + pinCode +
                ", desiredTeam=" + desiredTeam +
                ", desiredPositions=" + desiredPositions +
                '}';
    }
}
