package common.presentation.dashboard

sealed class DashBoardUIEffect {
    data object NavigateToDetail : DashBoardUIEffect()
}
