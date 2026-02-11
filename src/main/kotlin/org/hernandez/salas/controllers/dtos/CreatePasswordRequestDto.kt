package org.hernandez.salas.controllers.dtos

data class CreatePasswordRequestDto(
    val userId: String,
    val password: String
)
