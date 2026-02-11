package org.hernandez.salas.kafka.events

data class PasswordCreatedEvent(
    val userId: String,
    val password: String
)
