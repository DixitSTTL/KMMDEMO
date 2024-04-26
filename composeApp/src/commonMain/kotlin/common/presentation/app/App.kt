package common.presentation.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import common.presentation.welcome.WelcomeScreen
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
