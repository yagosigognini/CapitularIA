package br.com.letrariaapp.network

import br.com.letrariaapp.data.GeminiGenerateContentRequest
import br.com.letrariaapp.data.GeminiGenerateContentResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface GeminiApiService {

    @POST("v1beta/models/gemini-2.5-flash:generateContent")
    suspend fun generateBookRecommendations(
        @Query("key") apiKey: String,
        @Body request: GeminiGenerateContentRequest
    ): Response<GeminiGenerateContentResponse>
}
