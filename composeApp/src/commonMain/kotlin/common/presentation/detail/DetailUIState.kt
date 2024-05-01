package common.presentation.detail

import common.data.model.DataMoreCars

data class DetailUIState(
    var showContent: Boolean = false,
    var currentModel: DataMoreCars = DataMoreCars("Fortuner GR", "12", "10", false, "car3.png"),
)
