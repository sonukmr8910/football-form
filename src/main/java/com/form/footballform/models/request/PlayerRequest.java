package com.form.footballform.models.request;

import java.util.List;

public class PlayerRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private Long countryCode;
    private String phoneNumber;
    private String email;
    private Long ageGroup;
    private String address;
    private Long city;
    private Long state;
    private Long country;
    private Integer pinCode;
    private Long desiredTeam;
    private List<Long> desiredPositions;

    public PlayerRequest() {
    }

    public PlayerRequest(String userName, String firstName, String lastName, Long countryCode, String phoneNumber, String email, Long ageGroup, String address, Long city, Long state, Long country, Integer pinCode, Long desiredTeam, List<Long> desiredPositions) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ageGroup = ageGroup;
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

    public Long getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Long countryCode) {
        this.countryCode = countryCode;
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

    public Long getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(Long ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Long getDesiredTeam() {
        return desiredTeam;
    }

    public void setDesiredTeam(Long desiredTeam) {
        this.desiredTeam = desiredTeam;
    }

    public List<Long> getDesiredPositions() {
        return desiredPositions;
    }

    public void setDesiredPositions(List<Long> desiredPositions) {
        this.desiredPositions = desiredPositions;
    }

    @Override
    public String toString() {
        return "PlayerRequest{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", countryCode=" + countryCode +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", ageGroup=" + ageGroup +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", state=" + state +
                ", country=" + country +
                ", pinCode=" + pinCode +
                ", desiredTeam=" + desiredTeam +
                ", desiredPositions=" + desiredPositions +
                '}';
    }
}
