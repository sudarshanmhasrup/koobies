package user.onboarding.feature.data.datasource.local.language

import koobies.shared.app.data.preferences.PreferencesManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import user.onboarding.feature.domain.model.language.AppLanguage

internal class LocalLanguageDataSourceImpl(
    private val preferencesManager: PreferencesManager
) : LocalLanguageDataSource {
    private val supportedAppLanguages = MutableStateFlow(
        value = listOf(
            AppLanguage(
                name = "English",
                message = "Use this app in English.",
                locale = "en",
                isSelected = true
            ),
            AppLanguage(
                name = "Hindi",
                message = "इस ऐप का उपयोग हिंदी में करें।",
                locale = "hi",
                isSelected = false
            ),
            AppLanguage(
                name = "Marathi",
                message = "हे अ‍ॅप मराठीत वापरा.",
                locale = "mr",
                isSelected = false
            ),
            AppLanguage(
                name = "Spanish",
                message = "Usa esta aplicación en español.",
                locale = "es",
                isSelected = false
            ),
            AppLanguage(
                name = "French",
                message = "Utilisez cette application en français.",
                locale = "fr",
                isSelected = false
            ),
            AppLanguage(
                name = "German",
                message = "Verwenden Sie diese App auf Deutsch.",
                locale = "de",
                isSelected = false
            ),
            AppLanguage(
                name = "Russian",
                message = "Используйте это приложение на русском.",
                locale = "ru",
                isSelected = false
            ),
            AppLanguage(
                name = "Chinese (Simplified)",
                message = "使用简体中文。",
                locale = "zh",
                isSelected = false
            ),
            AppLanguage(
                name = "Japanese",
                message = "このアプリを日本語で使う。",
                locale = "ja",
                isSelected = false
            ),
            AppLanguage(
                name = "Korean",
                message = "이 앱을 한국어로 사용하세요.",
                locale = "ko",
                isSelected = false
            )
        )
    )

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val selectedAppLanguage = preferencesManager.getSelectedAppLanguage().first()
            if (selectedAppLanguage.isEmpty()) {
                return@launch
            }

            updateSelectedAppLanguage(locale = selectedAppLanguage)
        }
    }

    override fun getSupportedAppLanguages(): Flow<List<AppLanguage>> {
        return supportedAppLanguages
    }

    override suspend fun updateSelectedAppLanguage(locale: String) {
        supportedAppLanguages.update { value ->
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