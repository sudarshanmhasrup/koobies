package user.onboarding.feature.data.datasource.local.language

import user.onboarding.feature.domain.model.language.AppLanguage

internal class LocalLanguageDataSourceImpl : LocalLanguageDataSource {
    private val supportedAppLanguages = listOf(
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

    override fun getSupportedAppLanguages(): List<AppLanguage> {
        return supportedAppLanguages
    }
}