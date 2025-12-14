package com.geneforge.android.data.api

import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login()
}