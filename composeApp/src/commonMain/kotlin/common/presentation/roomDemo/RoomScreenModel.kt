package common.presentation.roomDemo

import cafe.adriel.voyager.core.model.coroutineScope
import common.data.model.DataEmployee
import common.domain.usecase.IManageRoomUseCase
import common.presentation.base.BaseScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class RoomScreenModel(private val manageRoomUseCase: IManageRoomUseCase) :
    BaseScreenModel<RoomUIState, RoomUIEffect>(RoomUIState()), RoomInteractionListener {

    override val viewModelScope: CoroutineScope = coroutineScope

    init {
            getAllEmployee()
    }

    override fun updateName(string: String) {
        updateState { it.copy(txtName = string) }

    }

    override fun updateDepartment(string: String) {
        updateState { it.copy(txtDepartment = string) }
    }

    override fun addToDataBase() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataEmployee = DataEmployee(0, state.value.txtName, state.value.txtDepartment)
            manageRoomUseCase.addToRoom(dataEmployee)
            updateState { it.copy(txtName = "", txtDepartment = "") }
        }

    }

    override fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch {
            manageRoomUseCase.deleteAll()
        }
    }

    override fun deleteById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            manageRoomUseCase.deleteById(id)
        }
    }

    override fun getAllEmployee() {
        CoroutineScope(Dispatchers.IO).launch {
            manageRoomUseCase.getAllEmployee().collect { list ->
                updateState { it.copy(allEmployee = list) }
            }
        }
    }


}