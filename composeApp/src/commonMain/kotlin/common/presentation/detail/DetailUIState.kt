package common.presentation.detail

import common.data.model.DataMoreCars

data class DetailUIState(
    var showContent: Boolean = false,
    var currentModel: DataMoreCars = DataMoreCars(
        name = "Fortuner GR",
        kms = "12",
        fule = "10",
        isEv = false,
        image = "car3.png"
    ),
)
