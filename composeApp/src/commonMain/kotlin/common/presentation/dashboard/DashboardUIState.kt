package common.presentation.dashboard

import common.data.model.DataMoreCars

data class DashboardUIState(
    var showContent: Boolean=false,
    var currentModel: DataMoreCars = DataMoreCars("Fortuner GR","12","10",false,"car3.png"),
    var getMoreCars: List<DataMoreCars> = emptyList()
)
