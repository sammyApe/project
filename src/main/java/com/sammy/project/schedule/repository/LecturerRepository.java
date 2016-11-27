package com.sammy.project.schedule.repository;

import com.sammy.project.schedule.domain.Lecturer;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Lecturer entity.
 */
@SuppressWarnings("unused")
public interface LecturerRepository extends JpaRepository<Lecturer,Long> {

}
