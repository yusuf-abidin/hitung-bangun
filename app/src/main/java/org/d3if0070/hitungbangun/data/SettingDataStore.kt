package org.d3if0070.hitungbangun.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.emptyPreferences


private const val LAYOUT_PREFERENCES_NAME = "layout_preferences"

val Context.dataStore : DataStore<Preferences> by preferencesDataStore(
    name = LAYOUT_PREFERENCES_NAME
)

class SettingDataStore(preference_datastore: DataStore<Preferences>) {

    private val IS_LINEAR_LAYOUT_MANAGER =
        booleanPreferencesKey("is_linear_layout_manager")

    val preferenceFlow: Flow<Boolean> = preference_datastore.data
        .catch {
            if (it is  IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            }else {
                throw it
            }
        }
        .map { preferences ->
            preferences[IS_LINEAR_LAYOUT_MANAGER] ?: true
        }

    suspend fun saveLayoutToPreferencesStore(isLinearLayputManager: Boolean, context: Context) {
        context.dataStore.edit { preferences ->
            preferences[IS_LINEAR_LAYOUT_MANAGER] = isLinearLayputManager
        }
    }
}