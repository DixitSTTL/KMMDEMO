package common.presentation.dashboard

import common.data.model.DataMoreCars

data class DashboardUIState(
    var showContent: Boolean = false,
    var currentModel: DataMoreCars = DataMoreCars(
        name = "Fortuner GR",
        kms = "12",
        fule = "10",
        isEv = false,
        image = "car3.png"
    ),
    var getMoreCars: List<DataMoreCars> = emptyList()
)
