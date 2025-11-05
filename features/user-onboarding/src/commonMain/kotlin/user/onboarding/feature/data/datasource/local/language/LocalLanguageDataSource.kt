package user.onboarding.feature.data.datasource.local.language

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.language.AppLanguage

internal interface LocalLanguageDataSource {
    fun getSupportedAppLanguages(): Flow<List<AppLanguage>>
}