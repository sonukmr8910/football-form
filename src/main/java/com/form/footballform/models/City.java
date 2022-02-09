package com.form.footballform.models;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_sequence"
    )
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    public City() {
    }

    public City(Long id, String name, State state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
