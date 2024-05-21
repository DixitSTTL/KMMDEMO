package common.presentation.dashboard

import cafe.adriel.voyager.core.model.coroutineScope
import common.data.model.DataMoreCars
import common.domain.usecase.ManageDashBoardUseCase
import common.presentation.base.BaseScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class DashBoardScreenModel(
    private val manageDashBoardUseCase: ManageDashBoardUseCase,
) :
    BaseScreenModel<DashboardUIState, DashBoardUIEffect>(DashboardUIState()),
    DashBoardInteractionListener {

    init {
        loadMoreCars()
    }

    override val viewModelScope: CoroutineScope = coroutineScope

    override fun onClickToDetail() {
        sendNewEffect(DashBoardUIEffect.NavigateToDetail)
    }

    override fun updateCurrentModel(model: DataMoreCars) {
        updateState {
            it.copy(currentModel = model)
        }
        CoroutineScope(Dispatchers.IO).launch {
            manageDashBoardUseCase.addToRoom(model)
        }
    }

    override fun loadMoreCars() {

        updateState {
            it.copy(getMoreCars = manageDashBoardUseCase.getMoreCars())
        }
    }


}