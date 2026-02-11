package org.hernandez.salas.dtos

data class CreatePasswordRequestDto(
    val userId: String,
    val password: String
)
