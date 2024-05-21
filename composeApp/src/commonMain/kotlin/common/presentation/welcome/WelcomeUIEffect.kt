package common.presentation.welcome

sealed class WelcomeUIEffect {
    data object NavigateToDashBoard : WelcomeUIEffect()
    data object NavigateToRoom : WelcomeUIEffect()
    data object NavigateToKtor : WelcomeUIEffect()
}
