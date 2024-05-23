package common.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.core.KoinApplication

actual fun createData(applicationContext: KoinApplication): DataStore<Preferences> {
    val context: Context = applicationContext.koin.get()
    return createDataStore(
        producePath = {
            context.applicationContext.filesDir.resolve(dataStoreFileName).absolutePath
        }
    )
}