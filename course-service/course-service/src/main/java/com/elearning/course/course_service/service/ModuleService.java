package com.elearning.course.course_service.service;
import com.elearning.course.course_service.entity.Module;

import java.util.List;

public interface ModuleService {
    Module saveModule(Module module);
    List<Module> getModulesByCourse(Long courseId);
    List<Module> getAllModules();
}