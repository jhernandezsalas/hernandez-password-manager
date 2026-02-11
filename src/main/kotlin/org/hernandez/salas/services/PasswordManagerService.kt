package org.hernandez.salas.services

import org.hernandez.salas.controllers.dtos.CreatePasswordRequestDto

interface PasswordManagerService {
    fun createPassword(createRequest: CreatePasswordRequestDto): String
}
