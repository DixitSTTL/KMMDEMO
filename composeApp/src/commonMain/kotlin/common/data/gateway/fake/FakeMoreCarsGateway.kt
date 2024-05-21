package common.data.gateway.fake

import common.data.model.DataMoreCars
import common.database.AppDatabase
import common.domain.gateway.IFakeMoreCarsGateway
import kotlinx.coroutines.flow.FlowCollector

class FakeMoreCarsGateway(private val appDatabase: AppDatabase) : IFakeMoreCarsGateway {

    private val moreCarsLit =
        listOf(
            DataMoreCars(
                name = "Fortuner GR", kms = "12", fule = "10", isEv = false, image = "car3.png"
            ),
            DataMoreCars(
                name = "Tata Nexon EV", kms = "4", fule = "60", isEv = true, image = "nexon.png"
            ),
            DataMoreCars(
                name = "Rang Rover",
                kms = "2.8",
                fule = "25",
                isEv = false,
                image = "range-rover.png"
            ),
            DataMoreCars(
                name = "Audi E-Tron", kms = "7", fule = "47", isEv = true, image = "e-tron.png"
            ),
            DataMoreCars(
                name = "Porshe Taycan", kms = "10", fule = "62", isEv = true, image = "taycan.png"
            ),
            DataMoreCars(
                name = "Mercedes c-class",
                kms = "3.3",
                fule = "20",
                isEv = false,
                image = "mercedes-c-class.png"
            ),
            DataMoreCars(
                name = "Lamborgini Urus-s",
                kms = "5",
                fule = "30",
                isEv = false,
                image = "lamorgini-urus-s.png"
            )
        )


    override fun getMoreCars(): List<DataMoreCars> {
        return moreCarsLit

    }

    override suspend fun addToRoom(dataMoreCars: DataMoreCars) {

        appDatabase.getDao().insert(dataMoreCars)

        appDatabase.getDao().getAllAsFlow().collect(FlowCollector {

            it.forEach {
                println("DAtaCarrr-- " + it)
            }
        })

    }
}