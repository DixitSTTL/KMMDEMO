package common.presentation.welcome

import cafe.adriel.voyager.core.model.coroutineScope
import common.domain.usecase.IManageWelcomeUseCase
import common.presentation.base.BaseScreenModel
import kotlinx.coroutines.CoroutineScope

class WelcomeScreenModel(private val manageWelcomeUseCase: IManageWelcomeUseCase) :
    BaseScreenModel<WelcomeUIState, WelcomeUIEffect>(WelcomeUIState()), WelcomeInteractionListener {

    override val viewModelScope: CoroutineScope = coroutineScope

    override fun onClickToHome() {
        sendNewEffect(WelcomeUIEffect.NavigateToDashBoard)

    }

    override fun onClickToRoom() {
        sendNewEffect(WelcomeUIEffect.NavigateToRoom)
    }

    override fun onClickToKtor() {
        sendNewEffect(WelcomeUIEffect.NavigateToKtor)
    }

    override fun onShowContent(isShow: Boolean) {
        updateState { it.copy(showContent = isShow) }
    }

}