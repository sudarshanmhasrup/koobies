package user.onboarding.feature.data.datasource.local.language

import user.onboarding.feature.domain.model.language.AppLanguage

internal interface LocalLanguageDataSource {
    fun getSupportedAppLanguages(): List<AppLanguage>
}