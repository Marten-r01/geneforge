package com.geneforge.user.dto

data class AuthResponse(
    val token: String,
    val userId: Long
)