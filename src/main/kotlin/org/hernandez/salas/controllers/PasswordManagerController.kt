package org.hernandez.salas.controllers

import org.hernandez.salas.dtos.CreatePasswordRequestDto
import org.hernandez.salas.services.PasswordManagerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/passwords")
class PasswordManagerController(
    private val passwordManagerService: PasswordManagerService
) {

    @PostMapping
    fun createPassword(@RequestBody createRequest: CreatePasswordRequestDto): ResponseEntity<String> {
        val response = passwordManagerService.createPassword(createRequest)

        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping
    fun getPasswords(): ResponseEntity<String> {
        return ResponseEntity.ok("successful")
    }
}
