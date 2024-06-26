package common.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import common.presentation.welcome.WelcomeScreen

object MainContainer : Screen {
    @Composable
    override fun Content() {


        Scaffold {

            Column(Modifier.fillMaxSize().padding(it)) {

                Navigator(WelcomeScreen()) {
                    SlideTransition(it)
                }

            }

        }

    }
}