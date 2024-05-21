package common.presentation.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import common.presentation.main.MainContainer
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    MainApp.Content()

}

object MainApp : Screen {
    @Composable
    override fun Content() {


        MaterialTheme {
            MainContainer.Content()

        }
    }
}
