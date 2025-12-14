package com.geneforge.user.service

import com.geneforge.user.dto.AuthRequest
import com.geneforge.user.dto.AuthResponse
import com.geneforge.user.entity.User
import com.geneforge.user.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.security.authentication.BadCredentialsException

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val jwtService: JwtService,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(request: AuthRequest): AuthResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("User already exists")
        }
        
        val user = User(
            email = request.email,
            passwordHash = passwordEncoder.encode(request.password),
            fullName = request.fullName ?: ""
        )
        
        val savedUser = userRepository.save(user)
        val token = jwtService.generateToken(savedUser.id.toString(), savedUser.role)
        
        return AuthResponse(token, savedUser.id, savedUser.email, savedUser.fullName)
    }
    
    fun login(request: AuthRequest): AuthResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw BadCredentialsException("Invalid credentials")
        
        if (!passwordEncoder.matches(request.password, user.passwordHash)) {
            throw BadCredentialsException("Invalid credentials")
        }
        
        val token = jwtService.generateToken(user.id.toString(), user.role)
        return AuthResponse(token, user.id, user.email, user.fullName)
    }
}
