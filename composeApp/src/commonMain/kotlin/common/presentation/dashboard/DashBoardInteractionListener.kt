package common.presentation.dashboard

import common.data.model.DataMoreCars
import common.presentation.base.BaseInteractionListener

interface DashBoardInteractionListener : BaseInteractionListener {
    fun onClickToDetail()
    fun loadMoreCars()
    fun updateCurrentModel(model: DataMoreCars)

}