package org.hernandez.salas.events

data class PasswordCreatedEvent(
    val userId: String,
    val password: String
)
