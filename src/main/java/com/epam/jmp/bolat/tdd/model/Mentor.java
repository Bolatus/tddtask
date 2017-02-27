package com.epam.jmp.bolat.tdd.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dom on 25.02.2017.
 */
@Entity
public class Mentor {

    @Id
    @SequenceGenerator(name="mentor_id_seq", sequenceName="mentor_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="mentor_id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "mentor")
    private List<Mentee> mentees;

    public List<Mentee> getMentees() {
        return mentees;
    }

    public void setMentees(List<Mentee> mentees) {
        this.mentees = mentees;
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

    public Mentor(){

    }
    public Mentor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
