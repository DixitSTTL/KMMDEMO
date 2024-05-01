package common.presentation.detail

import common.data.model.DataMoreCars
import common.presentation.base.BaseInteractionListener

interface DetailInteractionListener : BaseInteractionListener {
    fun onClickToDetail()
    fun updateCurrentModel(model: DataMoreCars)
    fun onShowContent(isShow: Boolean)

}