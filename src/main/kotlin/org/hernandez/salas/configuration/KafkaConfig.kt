package org.hernandez.salas.configuration

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig {

    @Bean
    fun createTopic() : NewTopic {
        return TopicBuilder
            .name("password-created-events-topic")
            .partitions(3)
            .replicas(2)
            .configs(mapOf("min.insync.replicas" to "2"))
            .build()
    }
}