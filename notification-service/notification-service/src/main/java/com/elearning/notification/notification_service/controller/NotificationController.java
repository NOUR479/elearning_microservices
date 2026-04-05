package com.elearning.notification.notification_service.controller;

import com.elearning.notification.notification_service.dto.NotificationDTO;
import com.elearning.notification.notification_service.service.NotificationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<NotificationDTO> streamNotifications() {
        return service.subscribe();
    }

    @PostMapping
    public void sendNotification(@RequestBody NotificationDTO dto) {
        service.sendNotification(dto);
    }
}
