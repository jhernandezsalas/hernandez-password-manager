package org.hernandez.salas.services

import org.hernandez.salas.dtos.CreatePasswordRequestDto

interface PasswordManagerService {
    fun createPassword(createRequest: CreatePasswordRequestDto): String
}
