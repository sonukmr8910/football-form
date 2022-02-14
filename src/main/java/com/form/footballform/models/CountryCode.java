package com.form.footballform.models;

import javax.persistence.*;

@Entity
public class CountryCode {
    @Id
    @SequenceGenerator(
            name = "country_code_sequence",
            sequenceName = "country_code_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_code_sequence"
    )
    private Long id;
    private String code;

    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public CountryCode() {
    }

    public CountryCode(Long id, String code, Country country) {
        this.id = id;
        this.code = code;
        this.country = country;
    }

    public CountryCode(String code, Country country) {
        this.code = code;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CountryCode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", country=" + country +
                '}';
    }
}
