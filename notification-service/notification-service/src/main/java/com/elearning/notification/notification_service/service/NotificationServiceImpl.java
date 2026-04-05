package com.elearning.notification.notification_service.service;

import com.elearning.notification.notification_service.dto.NotificationDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final Sinks.Many<NotificationDTO> sink =
            Sinks.many().multicast().directBestEffort();

    @Override
    public void sendNotification(NotificationDTO notification) {
        sink.tryEmitNext(notification);
    }

    @Override
    public Flux<NotificationDTO> subscribe() {
        return sink.asFlux();
    }
}