package com.elearning.course.course_service.repository;

import com.elearning.course.course_service.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
