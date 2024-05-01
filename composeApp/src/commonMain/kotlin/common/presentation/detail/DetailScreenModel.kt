package common.presentation.detail

import cafe.adriel.voyager.core.model.coroutineScope
import common.data.model.DataMoreCars
import common.presentation.base.BaseScreenModel
import kotlinx.coroutines.CoroutineScope

class DetailScreenModel :
    BaseScreenModel<DetailUIState, DetailUIEffect>(DetailUIState()),
    DetailInteractionListener {

    override val viewModelScope: CoroutineScope = coroutineScope

    override fun onClickToDetail() {
    }

    override fun updateCurrentModel(model: DataMoreCars) {
        updateState {
            it.copy(currentModel = model)
        }
    }

    override fun onShowContent(isShow: Boolean) {
        updateState {
            it.copy(showContent = isShow)
        }
    }


}