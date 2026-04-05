package com.elearning.course.course_service.service;

import com.elearning.notification.notification_service.dto.NotificationDTO;

import com.elearning.course.course_service.dto.CourseDTO;
import com.elearning.course.course_service.dto.ModuleDTO;
import com.elearning.course.course_service.entity.Course;
import com.elearning.course.course_service.repository.CourseRepository;
import com.elearning.course.course_service.repository.ModuleRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import com.elearning.course.course_service.entity.Module;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepo;
    private final ModuleRepository moduleRepo;
    private final RabbitTemplate rabbitTemplate;

    public CourseServiceImpl(CourseRepository courseRepo, ModuleRepository moduleRepo,RabbitTemplate rabbitTemplate) {
        this.courseRepo = courseRepo;
        this.moduleRepo = moduleRepo;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepo.findAll().stream()
                .map(c -> new CourseDTO(c.getId(), c.getTitle(), c.getDescription()))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO addCourse(CourseDTO dto) {
        Course course = new Course();
        course.setTitle(dto.title());
        course.setDescription(dto.description());
        courseRepo.save(course);

        // Publier événement vers RabbitMQ
        rabbitTemplate.convertAndSend(
                "elearning-exchange",
                "course.created",
                new NotificationDTO("Nouveau cours créé : " + course.getTitle())
        );
        return new CourseDTO(course.getId(), course.getTitle(), course.getDescription());
    }

    @Override
    public ModuleDTO addModule(ModuleDTO dto) {
        Module module = new Module();
        module.setCourseId(dto.courseId());
        module.setTitle(dto.title());
        module.setContent(dto.content());
        moduleRepo.save(module);

        // Publier notification sur RabbitMQ
        rabbitTemplate.convertAndSend(
                "elearning-exchange",
                "course.created", // tu peux créer une clé spécifique si tu veux "module.created"
                new NotificationDTO("Nouveau module créé : " + module.getTitle() + " pour le cours " + module.getCourseId())
        );
        return new ModuleDTO(module.getId(), module.getCourseId(), module.getTitle(), module.getContent());
    }
}
