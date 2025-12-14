package com.geneforge.user.controller

import com.geneforge.user.dto.AuthRequest
import com.geneforge.user.dto.AuthResponse
import com.geneforge.user.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> {
        return ResponseEntity.ok(authService.register(request))
    }

    @PostMapping("/login")
    fun login(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> {
        return ResponseEntity.ok(authService.login(request))
    }
}