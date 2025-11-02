package user.onboarding.feature.data.datasource.local.language

import koobies.shared.app.domain.preferences.PreferencesManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import user.onboarding.feature.domain.model.language.Language

internal class LocalLanguageDataSourceImpl(
    private val userPreferencesManager: PreferencesManager
) : LocalLanguageDataSource {
    private val languageList = MutableStateFlow(
        value = listOf(
            Language(
                name = "English",
                message = "Use this app in English.",
                locale = "en",
                isSelected = true
            ),
            Language(
                name = "Hindi",
                message = "इस ऐप का उपयोग हिंदी में करें।",
                locale = "hi",
                isSelected = false
            ),
            Language(
                name = "Marathi",
                message = "हे अ‍ॅप मराठीत वापरा.",
                locale = "mr",
                isSelected = false
            ),
            Language(
                name = "Spanish",
                message = "Usa esta aplicación en español.",
                locale = "es",
                isSelected = false
            ),
            Language(
                name = "French",
                message = "Utilisez cette application en français.",
                    locale = "fr",
                isSelected = false
            ),
            Language(
                name = "German",
                message = "Verwenden Sie diese App auf Deutsch.",
                locale = "de",
                isSelected = false
            ),
            Language(
                name = "Russian",
                message = "Используйте это приложение на русском.",
                locale = "ru",
                isSelected = false
            ),
            Language(
                name = "Chinese (Simplified)",
                message = "使用简体中文。",
                locale = "zh",
                isSelected = false
            ),
            Language(
                name = "Japanese",
                message = "このアプリを日本語で使う。",
                locale = "ja",
                isSelected = false
            ),
            Language(
                name = "Korean",
                message = "이 앱을 한국어로 사용하세요.",
                locale = "ko",
                isSelected = false
            )
        )
    )

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val selectedLanguage = userPreferencesManager.getSelectedLanguage().first()

            if (selectedLanguage.isEmpty()) {
                return@launch
            }
            updateSelectedLanguage(locale = selectedLanguage)
        }
    }

    override fun getLanguages(): Flow<List<Language>> {
        return languageList
    }

    override suspend fun updateSelectedLanguage(locale: String) {
        languageList.update { value ->
            value.map {
                if (it.locale == locale) {
                    it.copy(isSelected = true)
                } else {
                    it.copy(isSelected = false)
                }
            }
        }
    }
}