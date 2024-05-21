package common.presentation.roomDemo

import common.data.model.DataEmployee

data class RoomUIState(
    var txtName: String = "",
    var txtDepartment: String = "",
    var allEmployee: List<DataEmployee> = emptyList()
)
