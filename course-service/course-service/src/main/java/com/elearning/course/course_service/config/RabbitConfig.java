package com.elearning.course.course_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE = "elearning-exchange";
    public static final String USER_CREATED_QUEUE = "user.created.queue";
    public static final String COURSE_CREATED_QUEUE = "course.created.queue";

    @Bean
    public Queue userCreatedQueue() {
        return new Queue(USER_CREATED_QUEUE, true);
    }

    @Bean
    public Queue courseCreatedQueue() {
        return new Queue(COURSE_CREATED_QUEUE, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding userCreatedBinding(Queue userCreatedQueue, DirectExchange exchange) {
        return BindingBuilder.bind(userCreatedQueue).to(exchange).with("user.created");
    }

    @Bean
    public Binding courseCreatedBinding(Queue courseCreatedQueue, DirectExchange exchange) {
        return BindingBuilder.bind(courseCreatedQueue).to(exchange).with("course.created");
    }
}