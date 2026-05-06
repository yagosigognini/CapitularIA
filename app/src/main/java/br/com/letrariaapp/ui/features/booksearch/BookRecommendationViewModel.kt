package br.com.letrariaapp.ui.features.booksearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.letrariaapp.data.GeminiContent
import br.com.letrariaapp.data.GeminiGenerateContentRequest
import br.com.letrariaapp.data.GeminiPart
import br.com.letrariaapp.data.toRecommendationText
import br.com.letrariaapp.network.GeminiRetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class BookRecommendationState {
    data object Idle : BookRecommendationState()
    data object Loading : BookRecommendationState()
    data class Success(val recommendationText: String) : BookRecommendationState()
    data class Error(val message: String) : BookRecommendationState()
}

class BookRecommendationViewModel : ViewModel() {

    private val geminiApiService = GeminiRetrofitInstance.api
    private val geminiApiKey = GeminiRetrofitInstance.apiKey

    private val _recommendationState = MutableStateFlow<BookRecommendationState>(BookRecommendationState.Idle)
    val recommendationState: StateFlow<BookRecommendationState> = _recommendationState

    fun generateRecommendations(preferences: String) {
        if (preferences.isBlank()) {
            _recommendationState.value = BookRecommendationState.Error("Descreva suas preferências para gerar recomendações.")
            return
        }

        if (geminiApiKey.isBlank()) {
            _recommendationState.value = BookRecommendationState.Error("GEMINI_API_KEY não configurada no local.properties")
            return
        }

        viewModelScope.launch {
            _recommendationState.value = BookRecommendationState.Loading

            val prompt = """
                Você é um assistente literário. Recomende 5 livros com base no gosto do usuário.
                Para cada livro, devolva: Título, Autor, Motivo da recomendação (1 linha).
                Preferências do usuário: $preferences
            """.trimIndent()

            val request = GeminiGenerateContentRequest(
                contents = listOf(
                    GeminiContent(parts = listOf(GeminiPart(text = prompt)))
                )
            )

            try {
                val response = geminiApiService.generateBookRecommendations(
                    apiKey = geminiApiKey,
                    request = request
                )

                if (response.isSuccessful) {
                    val recommendationText = response.body()?.toRecommendationText()
                    if (recommendationText.isNullOrBlank()) {
                        _recommendationState.value = BookRecommendationState.Error("Resposta da Gemini vazia.")
                    } else {
                        _recommendationState.value = BookRecommendationState.Success(recommendationText)
                    }
                } else {
                    _recommendationState.value = BookRecommendationState.Error(
                        "Erro Gemini: ${response.code()} - ${response.message()}"
                    )
                }
            } catch (e: Exception) {
                _recommendationState.value = BookRecommendationState.Error(
                    "Falha ao conectar na Gemini: ${e.message}"
                )
            }
        }
    }

    fun resetState() {
        _recommendationState.value = BookRecommendationState.Idle
    }
}
