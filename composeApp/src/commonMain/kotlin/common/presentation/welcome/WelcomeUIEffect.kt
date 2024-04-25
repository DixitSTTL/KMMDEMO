package common.presentation.welcome

sealed class WelcomeUIEffect {
    data object NavigateToDashBoard : WelcomeUIEffect()
}
