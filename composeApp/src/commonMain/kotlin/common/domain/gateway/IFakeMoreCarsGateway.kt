package common.domain.gateway

import common.data.model.DataMoreCars

interface IFakeMoreCarsGateway {

    fun getMoreCars(): List<DataMoreCars>

    suspend fun addToRoom(dataMoreCars: DataMoreCars)

}