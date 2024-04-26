package common.data.gateway.fake

import common.data.model.DataMoreCars
import common.domain.gateway.IFakeMoreCarsGateway

class FakeMoreCarsGateway : IFakeMoreCarsGateway {

    private val moreCarsLit =
        listOf(
            DataMoreCars(
                "Fortuner GR", "12", "10", false, "car3.png"
            ),
            DataMoreCars(
                "Tata Nexon EV", "4", "60", true, "nexon.png"
            ),
            DataMoreCars(
                "Rang Rover", "2.8", "25", false, "range-rover.png"
            ),
            DataMoreCars(
                "Audi E-Tron", "7", "47", true, "e-tron.png"
            ),
            DataMoreCars(
                "Porshe Taycan", "10", "62", true, "taycan.png"
            ),
            DataMoreCars(
                "Mercedes c-class", "3.3", "20", false, "mercedes-c-class.png"
            ),
            DataMoreCars(
                "Lamborgini Urus-s", "5", "30", false, "lamorgini-urus-s.png"
            )
        )


    override fun getMoreCars(): List<DataMoreCars> {
        return moreCarsLit

    }
}