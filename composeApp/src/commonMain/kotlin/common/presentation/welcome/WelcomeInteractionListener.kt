package common.presentation.welcome

import common.presentation.base.BaseInteractionListener

interface WelcomeInteractionListener : BaseInteractionListener {
    fun  onClickToHome()
    fun  onShowContent(isShow :Boolean)

}