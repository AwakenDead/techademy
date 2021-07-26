package com.akhilesh.techademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhilesh.techademy.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
