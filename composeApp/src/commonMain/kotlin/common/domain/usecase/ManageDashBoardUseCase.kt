package common.domain.usecase

import common.data.gateway.fake.FakeMoreCarsGateway
import common.data.model.DataMoreCars


interface IManageDashBoardUseCase {
    fun getMoreCars(): List<DataMoreCars>
    suspend fun addToRoom(dataMoreCars: DataMoreCars)

}

class ManageDashBoardUseCase(private val fakeMoreCarsGateway: FakeMoreCarsGateway) :
    IManageDashBoardUseCase {
    override fun getMoreCars(): List<DataMoreCars> {
        return fakeMoreCarsGateway.getMoreCars()
    }

    override suspend fun addToRoom(dataMoreCars: DataMoreCars) {
        return fakeMoreCarsGateway.addToRoom(dataMoreCars)
    }

}
