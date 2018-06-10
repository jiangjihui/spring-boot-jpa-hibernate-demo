package com.models;

import javax.persistence.*;

@Entity
@Table(name = "dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "idGenerator")
    @TableGenerator(name = "idGenerator", allocationSize = 1)
    private Integer id;
    @Column
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
