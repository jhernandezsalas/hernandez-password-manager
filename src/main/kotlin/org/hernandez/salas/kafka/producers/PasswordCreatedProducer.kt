package org.hernandez.salas.kafka.producers

import org.hernandez.salas.events.PasswordCreatedEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PasswordCreatedProducer(
   private val kafkaTemplate: KafkaTemplate<String, PasswordCreatedEvent>
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(PasswordCreatedProducer::class.java)
    }

    fun publishEvent(event: PasswordCreatedEvent): Boolean {
        val response = kafkaTemplate.send(
            "password-created-events-topic",
            UUID.randomUUID().toString(),
            event
        )

        response.whenComplete { r, e ->
            if (e != null) {
                logger.error(e.message)
            } else {
                logger.info(r.toString())
            }
        }

        return true
    }
}
