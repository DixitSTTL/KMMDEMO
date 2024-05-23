package common.util

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.core.KoinApplication

actual fun createData(applicationContext: KoinApplication): DataStore<Preferences> {

  return  createDataStore { dataStoreFileName }
}