package user.onboarding.feature.domain.repository.language

import io.github.sudarshanmhasrup.localina.api.Locale
import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.language.AppLanguage

internal interface LanguageRepository {
    fun getSupportedAppLanguages(): Flow<List<AppLanguage>>
    suspend fun updateSelectedAppLanguage(language: AppLanguage)
}