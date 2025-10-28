package user.onboarding.feature.data.datasource.local.language

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import user.onboarding.feature.domain.model.language.Language

internal class LocalLanguageDataSourceImpl : LocalLanguageDataSource {
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
            )
        )
    )

    override fun getLanguages(): Flow<List<Language>> {
        return languageList
    }

    override fun updateSelectedLanguage(language: Language) {
        languageList.update { value ->
            value.map {
                if (it.locale == language.locale) {
                    it.copy(isSelected = true)
                } else {
                    it.copy(isSelected = false)
                }
            }
        }
    }
}