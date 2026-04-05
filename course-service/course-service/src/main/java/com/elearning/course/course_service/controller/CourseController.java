package com.elearning.course.course_service.controller;

import com.elearning.course.course_service.dto.CourseDTO;
import com.elearning.course.course_service.dto.ModuleDTO;
import com.elearning.course.course_service.entity.Course;
import com.elearning.course.course_service.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) { this.service = service; }

    @GetMapping("/all")
    public List<CourseDTO> getAll() { return service.getAllCourses(); }

    @PostMapping
    public CourseDTO addCourse(@RequestBody CourseDTO dto) { return service.addCourse(dto); }

    @PostMapping("/modules")
    public ModuleDTO addModule(@RequestBody ModuleDTO dto) { return service.addModule(dto); }
}