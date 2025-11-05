package user.onboarding.feature.data.datasource.local.language

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import user.onboarding.feature.domain.model.language.AppLanguage

internal class LocalLanguageDataSourceImpl : LocalLanguageDataSource {
    private val supportedAppLanguages = flowOf(
        value = listOf(
            AppLanguage(
                name = "English",
                message = "Use this app in English.",
                locale = "en"
            ),
            AppLanguage(
                name = "Hindi",
                message = "इस ऐप का उपयोग हिंदी में करें।",
                locale = "hi"
            ),
            AppLanguage(
                name = "Marathi",
                message = "हे अ‍ॅप मराठीत वापरा.",
                locale = "mr"
            ),
            AppLanguage(
                name = "Spanish",
                message = "Usa esta aplicación en español.",
                locale = "es"
            ),
            AppLanguage(
                name = "French",
                message = "Utilisez cette application en français.",
                locale = "fr"
            ),
            AppLanguage(
                name = "German",
                message = "Verwenden Sie diese App auf Deutsch.",
                locale = "de"
            ),
            AppLanguage(
                name = "Russian",
                message = "Используйте это приложение на русском.",
                locale = "ru"
            ),
            AppLanguage(
                name = "Chinese (Simplified)",
                message = "使用简体中文。",
                locale = "zh"
            ),
            AppLanguage(
                name = "Japanese",
                message = "このアプリを日本語で使う。",
                locale = "ja"
            ),
            AppLanguage(
                name = "Korean",
                message = "이 앱을 한국어로 사용하세요.",
                locale = "ko"
            )
        )
    )

    override fun getSupportedAppLanguages(): Flow<List<AppLanguage>> {
        return supportedAppLanguages
    }
}