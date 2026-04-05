package com.elearning.course.course_service.controller;

import com.elearning.course.course_service.entity.Module;
import com.elearning.course.course_service.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;

    @PostMapping
    public Module create(@RequestBody Module module) {
        return moduleService.saveModule(module);
    }

    @GetMapping("/course/{courseId}")
    public List<Module> getByCourse(@PathVariable Long courseId) {
        return moduleService.getModulesByCourse(courseId);
    }

    @GetMapping
    public List<Module> getAll() {
        return moduleService.getAllModules();
    }
}