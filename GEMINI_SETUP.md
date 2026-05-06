# Preparação para recomendações de livros com Gemini

## 1) Configuração de chave local
No arquivo `local.properties` (não versionado), adicione:

```properties
GEMINI_API_KEY=sua_chave_gemini_aqui
GOOGLE_BOOKS_API_KEY=sua_chave_google_books_aqui
```

A chave da Gemini é exposta para o app via `BuildConfig.GEMINI_API_KEY`.

## 2) Estrutura adicionada
- `GeminiApiService`: endpoint `generateContent` para pedir recomendações.
- `GeminiRetrofitInstance`: cliente Retrofit dedicado para a API Gemini.
- `GeminiModels`: modelos de request/response para parse da resposta.
- `BookRecommendationViewModel`: fluxo pronto para gerar recomendações por texto de preferência.

## 3) Próximo passo de UI
Conectar a `BookRecommendationViewModel` em uma tela Compose com:
- campo de texto para preferências
- botão "Gerar recomendações"
- renderização por estado (`Idle`, `Loading`, `Success`, `Error`)

## 4) Observações de revisão de código
- Hoje há uso direto de `RetrofitInstance` dentro de `BookSearchViewModel`. Futuramente vale injetar dependências para facilitar testes.
- Logs detalhados no `BookSearchViewModel` estão úteis para debug, mas podem ser reduzidos quando o fluxo estiver estável.
- Falta camada de repositório para separar melhor regra de negócio da camada de UI.
