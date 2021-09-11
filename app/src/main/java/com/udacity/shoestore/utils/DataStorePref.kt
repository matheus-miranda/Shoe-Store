package com.udacity.shoestore.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class DataStorePref(private val context: Context) {

    /**
     * Sava to DataStore when user first logs in
     */
    suspend fun saveToDataStore(key: String, hasLoggedIn: Boolean) {
        val dataStoreKey = booleanPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings[dataStoreKey] = hasLoggedIn
        }
    }

    /**
     * Reads from DataStore to determine is user has logged in before
     */
    suspend fun readFromDataStore(key: String): Boolean? {
        val dataStoreKey = booleanPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[dataStoreKey]
    }

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
        const val KEY = "login"
    }
}