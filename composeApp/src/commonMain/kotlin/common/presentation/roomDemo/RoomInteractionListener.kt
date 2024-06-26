package common.presentation.roomDemo

import common.data.model.DataEmployee
import common.presentation.base.BaseInteractionListener

interface RoomInteractionListener : BaseInteractionListener {
    fun updateName(string: String)
    fun updateDepartment(string: String)
    fun addToDataBase()
    fun deleteAll()
    fun deleteById(id: Int)
    fun getAllEmployee()
    fun updateUser(dataEmployee: DataEmployee)
    fun getLatestUser()
}