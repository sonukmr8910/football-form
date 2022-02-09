package com.form.footballform.models;

import javax.persistence.*;

@Entity
public class Position {
    @Id
    @SequenceGenerator(
            name = "position_sequence",
            sequenceName = "position_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "position_sequence"
    )
    private Long id;

    private String name;

    public Position() {
    }

    public Position(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Position(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
