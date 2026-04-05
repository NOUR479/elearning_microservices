package com.elearning.course.course_service.repository;

import com.elearning.course.course_service.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module,Long> {
    List<Module> findByCourseId(Long courseId);
}