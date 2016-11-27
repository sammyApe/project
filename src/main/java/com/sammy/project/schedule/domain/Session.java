package com.sammy.project.schedule.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Session.
 */
@Entity
@Table(name = "session")
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "session")
    @JsonIgnore
    private Set<Lecturer> lecturerLists = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Session name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lecturer> getLecturerLists() {
        return lecturerLists;
    }

    public Session lecturerLists(Set<Lecturer> lecturers) {
        this.lecturerLists = lecturers;
        return this;
    }

    public Session addLecturerList(Lecturer lecturer) {
        lecturerLists.add(lecturer);
        lecturer.setSession(this);
        return this;
    }

    public Session removeLecturerList(Lecturer lecturer) {
        lecturerLists.remove(lecturer);
        lecturer.setSession(null);
        return this;
    }

    public void setLecturerLists(Set<Lecturer> lecturers) {
        this.lecturerLists = lecturers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Session session = (Session) o;
        if(session.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Session{" +
            "id=" + id +
            ", name='" + name + "'" +
            '}';
    }
}
