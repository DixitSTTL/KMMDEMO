package common.domain.usecase

import common.data.gateway.local.LocalEmployeeGateway
import common.data.model.DataEmployee
import kotlinx.coroutines.flow.Flow


interface IManageRoomUseCase {

    suspend fun addToRoom(dataEmployee: DataEmployee)
    suspend fun getAllEmployee(): Flow<List<DataEmployee>>
    suspend fun deleteAll()
    suspend fun deleteById(id: Int)
    suspend fun updateUser(dataEmployee: DataEmployee)
    suspend fun getLatestUser():Flow<String>
}

class ManageRoomUseCase(private val localEmployeeGateway: LocalEmployeeGateway) :
    IManageRoomUseCase {
    override suspend fun addToRoom(dataEmployee: DataEmployee) {
        localEmployeeGateway.addEmployee(dataEmployee)
    }

    override suspend fun getAllEmployee(): Flow<List<DataEmployee>> {
        return localEmployeeGateway.getAllEmployee()
    }

    override suspend fun deleteAll() {
        localEmployeeGateway.deleteAll()

    }

    override suspend fun deleteById(id: Int) {
        localEmployeeGateway.deleteById(id)
    }

    override suspend fun updateUser(dataEmployee: DataEmployee) {
        localEmployeeGateway.updateUser(dataEmployee)
    }

    override suspend fun getLatestUser(): Flow<String> {
       return localEmployeeGateway.getLatestUser()
    }

}