# 📚 Letraria

> Uma rede social de leitura em Android para clubes do livro, com chat, ciclos de indicação e recursos de comunidade.

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-6c63ff)
![Android](https://img.shields.io/badge/Android-29%2B-3DDC84?logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0-7F52FF?logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack-Compose-4285F4)
![Firebase](https://img.shields.io/badge/Firebase-Auth%20%7C%20Firestore%20%7C%20Storage-FFCA28?logo=firebase&logoColor=black)

---

## ✨ Visão geral

O **Letraria** é um app focado em leitura colaborativa:

- criação e participação em **clubes de leitura**;
- **chat por clube** para conversar durante os ciclos;
- sorteio de membro para **indicação do próximo livro**;
- integração com **Google Books** para busca de livros;
- base pronta para recomendações por IA com **Gemini**.

A proposta é transformar o hábito de leitura em experiência social, divertida e contínua.

---

## 🧩 Funcionalidades atuais

- ✅ Cadastro e login (e-mail/senha + Google)
- ✅ Verificação de e-mail
- ✅ Perfil de usuário e edição de informações
- ✅ Criação/entrada em clubes
- ✅ Chat principal do clube
- ✅ Indicação de livro por ciclo
- ✅ Busca de livros via Google Books API
- ✅ Integração Firebase (Auth, Firestore, Storage, FCM)

---

## 🗺️ Roadmap (próximos passos)

- [ ] Recomendações no clube via Gemini (com prompt personalizado)
- [ ] Histórico persistente de leituras por clube
- [ ] Gamificação avançada (títulos, badges e progresso)
- [ ] Melhorias de moderação e administração dos clubes
- [ ] Testes automatizados mais abrangentes

---

## 🛠️ Stack técnica

- **Linguagem:** Kotlin
- **UI:** Jetpack Compose
- **Arquitetura:** MVVM + estados (`LiveData`/`StateFlow`)
- **Backend:** Firebase (Auth, Firestore, Storage, FCM)
- **Networking:** Retrofit + Gson + OkHttp
- **Imagens:** Coil

---

## 📁 Organização do projeto

```text
app/src/main/java/br/com/letrariaapp/
├── data/                 # Modelos de dados (Book, Message, User, etc.)
├── network/              # Serviços Retrofit (Google Books / Gemini)
├── services/             # Serviços auxiliares (ex.: token FCM)
├── ui/
│   ├── components/       # Componentes reutilizáveis
│   ├── features/         # Telas e ViewModels por feature
│   └── theme/            # Tema/cores/tipografia
└── MainActivity.kt       # Entrada e navegação principal
```

---

## 🚀 Como rodar localmente

### 1) Pré-requisitos

- Android Studio atualizado
- JDK 11+
- Conta Firebase configurada
- (Opcional) Chaves Google Books e Gemini

### 2) Clonar e abrir

```bash
git clone <url-do-repositorio>
cd CapitularIA
```

Abra o projeto no Android Studio e aguarde sincronização do Gradle.

### 3) Configurar `local.properties`

No arquivo `local.properties` (na raiz), adicione:

```properties
GOOGLE_BOOKS_API_KEY=sua_chave_google_books
GEMINI_API_KEY=sua_chave_gemini
```

> Essas chaves são injetadas no app via `BuildConfig`.

### 4) Executar

- Escolha um emulador/dispositivo Android
- Rode o app pela IDE (`Run 'app'`)

---

## 🔐 Segurança e boas práticas

- Nunca commitar chaves reais no Git.
- Use regras de segurança no Firestore.
- Validar permissões (notificações, rede e armazenamento) por ambiente.

---

## 🤝 Contribuição

Contribuições são bem-vindas!

Sugestão de fluxo:
1. Crie uma branch (`feature/minha-feature`)
2. Faça commits pequenos e claros
3. Abra PR com contexto + evidências de teste

---

## 📄 Licença

Projeto em desenvolvimento interno. Definir licença pública quando apropriado.

---

## 💙 Sobre o nome

**Letraria** vem da ideia de um lugar para letras, histórias e encontros.

Se leitura é jornada, aqui ela é coletiva. 📖✨
