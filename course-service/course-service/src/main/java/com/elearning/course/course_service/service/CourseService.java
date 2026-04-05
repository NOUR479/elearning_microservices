package com.elearning.course.course_service.service;

import com.elearning.course.course_service.dto.CourseDTO;
import com.elearning.course.course_service.dto.ModuleDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses();
    CourseDTO addCourse(CourseDTO courseDTO);
    ModuleDTO addModule(ModuleDTO moduleDTO);
}
