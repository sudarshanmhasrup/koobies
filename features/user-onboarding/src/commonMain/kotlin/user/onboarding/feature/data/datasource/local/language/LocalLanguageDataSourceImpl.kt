package user.onboarding.feature.data.datasource.local.language

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import user.onboarding.feature.domain.model.language.AppLanguage

internal class LocalLanguageDataSourceImpl : LocalLanguageDataSource {
    override fun getSupportedAppLanguages(): Flow<List<AppLanguage>> {
        return flowOf(LanguageConstants.SUPPORTED_LANGUAGES)
    }
}