package com.elearning.course.course_service.service;

import com.elearning.course.course_service.entity.Module;
import com.elearning.course.course_service.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    @Override
    public Module saveModule(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public List<Module> getModulesByCourse(Long courseId) {
        return moduleRepository.findByCourseId(courseId);
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }
}