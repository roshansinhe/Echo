package com.example.echo.login.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferences(private val context: Context) {

    companion object {
        private val KEY_PERSON_ID = intPreferencesKey("person_id")
        private val KEY_TOKEN = stringPreferencesKey("token")
        private val KEY_FIRST_NAME = stringPreferencesKey("first_name")
    }

    // 2. Save personId
    suspend fun savePersonId(id: Int) {
        context.dataStore.edit { prefs ->
            prefs[KEY_PERSON_ID] = id
        }
    }

    // 3. Get personId
    val personIdFlow: Flow<Int?> = context.dataStore.data
        .map { prefs ->
            prefs[KEY_PERSON_ID]
        }

    // 4. Save token
    suspend fun saveToken(token: String) {
        context.dataStore.edit { prefs ->
            prefs[KEY_TOKEN] = token
        }
    }

    // 5. Get token
    val tokenFlow: Flow<String?> = context.dataStore.data
        .map { prefs ->
            prefs[KEY_TOKEN]
        }

    // 6. Save firstName
    suspend fun saveFirstName(name: String) {
        context.dataStore.edit { prefs ->
            prefs[KEY_FIRST_NAME] = name
        }
    }

    // 7. Get firstName
    val firstNameFlow: Flow<String?> = context.dataStore.data
        .map { prefs ->
            prefs[KEY_FIRST_NAME]
        }
}