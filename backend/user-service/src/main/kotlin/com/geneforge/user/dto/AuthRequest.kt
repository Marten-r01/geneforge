package com.geneforge.user.dto

data class AuthRequest(
    val email: String,
    val password: String
)