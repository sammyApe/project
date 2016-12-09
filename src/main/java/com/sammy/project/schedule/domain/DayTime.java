package com.sammy.project.schedule.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sammy.project.schedule.domain.enumeration.Day;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * A DayTime.
 */
@Entity
@Table(name = "day_time")
public class DayTime implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_preference")
    private Day dayPreference;

    @ManyToMany()
    @JoinTable(name = "lecturer_dayTime", joinColumns = {
        @JoinColumn(name = "preferred_Day_ID", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "lecturer_ID")})
    @JsonIgnore
    private List<Lecturer> lecturerList;

    @OneToMany(mappedBy = "dayTime", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Time> timePreferenceList = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Day getDayPreference() {
        return dayPreference;
    }

    public DayTime dayPreference(Day dayPreference) {
        this.dayPreference = dayPreference;
        return this;
    }

    public void setDayPreference(Day dayPreference) {
        this.dayPreference = dayPreference;
    }

    public List<Lecturer> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(List<Lecturer> lecturerList) {
        this.lecturerList = lecturerList;
    }

    public Set<Time> getTimePreferenceList() {
        return timePreferenceList;
    }

    public DayTime timePreferenceLists(Set<Time> times) {
        this.timePreferenceList = times;
        return this;
    }

    public DayTime addTimePreferenceList(Time time) {
        timePreferenceList.add(time);
        time.setDayTime(this);
        return this;
    }

    public DayTime removeTimePreferenceList(Time time) {
        timePreferenceList.remove(time);
        time.setDayTime(null);
        return this;
    }

    public void setTimePreferenceList(Set<Time> times) {
        this.timePreferenceList = times;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DayTime dayTime = (DayTime) o;
        if (dayTime.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, dayTime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DayTime{" +
            "id=" + id +
            ", dayPreference='" + dayPreference + "'" +
            '}';
    }
}
