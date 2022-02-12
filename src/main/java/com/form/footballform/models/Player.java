package com.form.footballform.models;

import com.form.footballform.models.converter.StringPositionConverter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    private Long id;

    @Column(unique = true)
    private String userName;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "age_group_id")
    private AgeGroup ageGroup;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "desired_team_id")
    private Team desiredTeam;

    @Convert(converter = StringPositionConverter.class)
    private List<Position> desiredPositions;

    public Player() {
    }

    public Player(Long id, String userName, String firstName, String lastName, String phoneNumber, String email, AgeGroup ageGroup, Address address, Team desiredTeam, List<Position> desiredPositions) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ageGroup = ageGroup;
        this.address = address;
        this.desiredTeam = desiredTeam;
        this.desiredPositions = desiredPositions;
    }

    public Player(String userName, String firstName, String lastName, String phoneNumber, String email, AgeGroup ageGroup, Address address, Team desiredTeam, List<Position> desiredPositions) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ageGroup = ageGroup;
        this.address = address;
        this.desiredTeam = desiredTeam;
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

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
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

    public Team getDesiredTeam() {
        return desiredTeam;
    }

    public void setDesiredTeam(Team desiredTeam) {
        this.desiredTeam = desiredTeam;
    }

    public List<Position> getDesiredPositions() {
        return desiredPositions;
    }

    public void setDesiredPositions(List<Position> desiredPositions) {
        this.desiredPositions = desiredPositions;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", ageGroup=" + ageGroup +
                ", address=" + address +
                ", desiredTeam=" + desiredTeam +
                ", desiredPositions=" + desiredPositions +
                '}';
    }
}
