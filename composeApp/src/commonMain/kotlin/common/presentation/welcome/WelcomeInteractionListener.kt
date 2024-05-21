package common.presentation.welcome

import common.presentation.base.BaseInteractionListener

interface WelcomeInteractionListener : BaseInteractionListener {
    fun onClickToHome()
    fun onClickToRoom()
    fun onClickToKtor()
    fun onShowContent(isShow: Boolean)

}