package common.presentation.ktorDemo

data class KtorUIState(
    var isLoading: Boolean = true,
    var continents: List<String> = emptyList()

)