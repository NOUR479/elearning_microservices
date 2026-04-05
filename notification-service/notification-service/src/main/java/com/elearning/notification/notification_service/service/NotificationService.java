package com.elearning.notification.notification_service.service;

import com.elearning.notification.notification_service.dto.NotificationDTO;
import reactor.core.publisher.Flux;

public interface NotificationService {
    void sendNotification(NotificationDTO notification);
    Flux<NotificationDTO> subscribe();
}
