package common.domain.gateway

import common.data.model.DataEmployee
import kotlinx.coroutines.flow.Flow

interface ILocaleEmployeeGateway {

    suspend fun getAllEmployee(): Flow<List<DataEmployee>>
    suspend fun deleteAll()
    suspend fun deleteById(id: Int)
    suspend fun addEmployee(dataEmployee: DataEmployee)

}