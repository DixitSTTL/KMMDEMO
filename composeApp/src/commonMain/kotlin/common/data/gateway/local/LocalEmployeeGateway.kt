package common.data.gateway.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import common.data.model.DataEmployee
import common.database.AppDatabase
import common.domain.gateway.ILocaleEmployeeGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalEmployeeGateway(
    private val appDatabase: AppDatabase,
    private val dataStoreInstance: DataStore<Preferences>
) : ILocaleEmployeeGateway {

    override suspend fun getAllEmployee(): Flow<List<DataEmployee>> {
        return appDatabase.employeeDao().getAllAsFlow()
    }

    override suspend fun deleteAll() {
        appDatabase.employeeDao().deleteAll()
    }

    override suspend fun deleteById(id: Int) {
        appDatabase.employeeDao().deleteById(id)
    }

    override suspend fun addEmployee(dataEmployee: DataEmployee) {
        appDatabase.employeeDao().insert(dataEmployee)

    }

    override suspend fun updateUser(dataEmployee: DataEmployee) {
        dataStoreInstance.edit {
            it[stringPreferencesKey("dixit")] = dataEmployee.name
        }
    }

    override suspend fun getLatestUser(): Flow<String> {

        return dataStoreInstance.data.map {
            it[stringPreferencesKey("dixit")].toString()
        }
    }
}