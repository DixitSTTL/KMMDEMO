package common.presentation.ktorDemo

import cafe.adriel.voyager.core.model.coroutineScope
import common.domain.usecase.ManageKtorUseCase
import common.presentation.base.BaseScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch


class KtorScreenModel(
    private val manageKtorUseCase: ManageKtorUseCase
) :
    BaseScreenModel<KtorUIState, KtorUIEffect>(KtorUIState()), KtorInteractionListener {

    override val viewModelScope: CoroutineScope = coroutineScope

    override fun getContinents() {
        CoroutineScope(Dispatchers.IO).launch {
            val list = manageKtorUseCase.getContinents()
            updateState { it.copy(isLoading = false, continents = list) }
        }
    }

}