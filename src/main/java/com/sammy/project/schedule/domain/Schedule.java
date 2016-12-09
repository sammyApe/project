package com.sammy.project.schedule.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Schedule.
 */
@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "schedule")
    private Set<Lecturer> lecturerLists = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Schedule date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Schedule name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lecturer> getLecturerLists() {
        return lecturerLists;
    }

    public Schedule lecturerLists(Set<Lecturer> lecturers) {
        this.lecturerLists = lecturers;
        return this;
    }

    public Schedule addLecturerList(Lecturer lecturer) {
        lecturerLists.add(lecturer);
        lecturer.setSchedule(this);
        return this;
    }

    public Schedule removeLecturerList(Lecturer lecturer) {
        lecturerLists.remove(lecturer);
        lecturer.setSchedule(null);
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
        Schedule schedule = (Schedule) o;
        if(schedule.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Schedule{" +
            "id=" + id +
            ", date='" + date + "'" +
            ", name='" + name + "'" +
            '}';
    }
}
