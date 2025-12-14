package com.geneforge.user.service

import org.springframework.stereotype.Service

@Service
class JwtService {
    fun generateToken(userId: String, role: String): String {
        return "jwt-token"
    }
}