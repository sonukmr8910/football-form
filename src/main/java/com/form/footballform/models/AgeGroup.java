package com.form.footballform.models;

import javax.persistence.*;

@Entity
public class AgeGroup {
    @Id
    @SequenceGenerator(
            name = "age_group_sequence",
            sequenceName = "age_group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "age_group_sequence"
    )
    private Long id;
    private String name;

    public AgeGroup() {
    }

    public AgeGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AgeGroup(String name) {
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
        return "AgeGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
