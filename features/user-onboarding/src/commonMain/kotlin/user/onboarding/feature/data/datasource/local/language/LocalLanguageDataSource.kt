package user.onboarding.feature.data.datasource.local.language

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.language.AppLanguage

/**
 * Local data source interface for language-related operations.
 * Abstracts the retrieval of supported application languages from local storage.
 *
 * This interface follows the DataSource pattern to separate data access logic from business logic, providing a clear
 * contract for language data operations.
 */
internal interface LocalLanguageDataSource {
    /**
     * Retrieves the list of all supported application languages.
     * Returns a reactive Flow that emits the language list and updates
     * whenever the underlying data changes.
     *
     * @return Flow containing a list of all supported AppLanguage objects
     */
    fun getSupportedAppLanguages(): Flow<List<AppLanguage>>
}