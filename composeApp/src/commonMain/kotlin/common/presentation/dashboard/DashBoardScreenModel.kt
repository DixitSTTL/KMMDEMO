package common.presentation.dashboard

import cafe.adriel.voyager.core.model.coroutineScope
import common.domain.usecase.IManageWelcomeUseCase
import common.presentation.base.BaseScreenModel
import kotlinx.coroutines.CoroutineScope

class DashBoardScreenModel(private val manageWelcomeUseCase: IManageWelcomeUseCase) :
    BaseScreenModel<DashboardUIState, DashBoardUIEffect>(DashboardUIState()),
    DashBoardInteractionListener {

    override val viewModelScope: CoroutineScope = coroutineScope

    override fun onClickToDetail() {
    }


}