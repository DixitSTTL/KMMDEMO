package common.data.gateway.local

import common.data.model.DataEmployee
import common.database.AppDatabase
import common.domain.gateway.ILocaleEmployeeGateway
import kotlinx.coroutines.flow.Flow

class LocalEmployeeGateway(private val appDatabase: AppDatabase) : ILocaleEmployeeGateway {

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
}