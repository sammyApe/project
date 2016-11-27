package com.sammy.project.schedule.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sammy.project.schedule.domain.enumeration.SemesterEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Lecturer.
 */
@Entity
@Table(name = "lecturer")
public class Lecturer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "semester")
    private SemesterEnum semester;

    @OneToMany(mappedBy = "lecturer", cascade=CascadeType.DETACH)
    private Set<Course> courseLists = new HashSet<>();

    @OneToMany(mappedBy = "lecturer", cascade=CascadeType.PERSIST)
    private Set<DayTime> preferredDayTimeLists = new HashSet<>();

    @ManyToOne(cascade=CascadeType.PERSIST)
    private Session session;

    @ManyToOne
    @JsonIgnore
    private Schedule schedule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Lecturer name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SemesterEnum getSemester() {
        return semester;
    }

    public Lecturer semester(SemesterEnum semester) {
        this.semester = semester;
        return this;
    }

    public void setSemester(SemesterEnum semester) {
        this.semester = semester;
    }

    public Set<Course> getCourseLists() {
        return courseLists;
    }

    public Lecturer courseLists(Set<Course> courses) {
        this.courseLists = courses;
        return this;
    }

    public Lecturer addCourseList(Course course) {
        courseLists.add(course);
        course.setLecturer(this);
        return this;
    }

    public Lecturer removeCourseList(Course course) {
        courseLists.remove(course);
        course.setLecturer(null);
        return this;
    }

    public void setCourseLists(Set<Course> courses) {
        this.courseLists = courses;
    }

    public Set<DayTime> getPreferredDayTimeLists() {
        return preferredDayTimeLists;
    }

    public Lecturer preferredDayTimeLists(Set<DayTime> dayTimes) {
        this.preferredDayTimeLists = dayTimes;
        return this;
    }

    public Lecturer addPreferredDayTimeList(DayTime dayTime) {
        preferredDayTimeLists.add(dayTime);
        dayTime.setLecturer(this);
        return this;
    }

    public Lecturer removePreferredDayTimeList(DayTime dayTime) {
        preferredDayTimeLists.remove(dayTime);
        dayTime.setLecturer(null);
        return this;
    }

    public void setPreferredDayTimeLists(Set<DayTime> dayTimes) {
        this.preferredDayTimeLists = dayTimes;
    }

    public Session getSession() {
        return session;
    }

    public Lecturer session(Session session) {
        this.session = session;
        return this;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Lecturer schedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lecturer lecturer = (Lecturer) o;
        if(lecturer.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, lecturer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Lecturer{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", semester='" + semester + "'" +
            '}';
    }
}
