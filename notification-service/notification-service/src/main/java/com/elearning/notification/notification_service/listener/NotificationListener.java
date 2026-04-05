package com.elearning.notification.notification_service.listener;

import com.elearning.notification.notification_service.dto.NotificationDTO;
import com.elearning.notification.notification_service.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    private final NotificationService notificationService;

    public NotificationListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "user.created.queue")
    public void handleUserCreated(NotificationDTO dto) {
        notificationService.sendNotification(dto);
        System.out.println("Notification reçue (user) : " + dto.message());
    }

    @RabbitListener(queues = "course.created.queue")
    public void handleCourseCreated(NotificationDTO dto) {
        notificationService.sendNotification(dto);
        System.out.println("Notification reçue (course) : " + dto.message());
    }
}
