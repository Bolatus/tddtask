package com.epam.jmp.bolat.tdd.model;

import javax.persistence.*;

/**
 * Created by dom on 25.02.2017.
 */
@Entity
public class Mentee {

    @Id
    @SequenceGenerator(name="mentee_id_seq", sequenceName="mentee_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="mentee_id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="mentor_id")
    private Mentor mentor;

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
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

    public Mentee(){

    }
    public Mentee(Long id, String name, Mentor mentor) {
        this.id = id;
        this.name = name;
        this.mentor = mentor;
    }

    @Override
    public String toString() {
        return "Mentee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mentor=" + mentor +
                '}';
    }
}
