package com.form.footballform.models;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long id;

    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String pinCode;

    public Address() {
    }

    public Address(Long id, String address, City city, String pinCode) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
    }

    public Address(String address, City city, String pinCode) {
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", pinCode=" + pinCode +
                '}';
    }
}
