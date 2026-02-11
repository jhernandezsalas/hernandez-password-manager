package org.hernandez.salas.services.impl

import org.hernandez.salas.dtos.CreatePasswordRequestDto
import org.hernandez.salas.events.PasswordCreatedEvent
import org.hernandez.salas.kafka.producers.PasswordCreatedProducer
import org.hernandez.salas.services.PasswordManagerService
import org.springframework.stereotype.Service

@Service
class PasswordManagerServiceImpl(
    private val passwordProducer: PasswordCreatedProducer
) : PasswordManagerService {

    override fun createPassword(createRequest: CreatePasswordRequestDto): String {
        val worked = passwordProducer.publishEvent(
            PasswordCreatedEvent(
                userId = createRequest.userId,
                password = createRequest.password
            )
        )

        return "Password created"
    }
}