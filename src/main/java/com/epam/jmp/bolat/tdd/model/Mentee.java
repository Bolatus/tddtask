package com.epam.jmp.bolat.tdd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dom on 25.02.2017.
 */
@Entity
public class Mentee {

    @Id
   @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

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

    public Mentee(){

    }
    public Mentee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mentee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
