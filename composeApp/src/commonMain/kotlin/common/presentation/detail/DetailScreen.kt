package common.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.Navigator
import common.presentation.base.BaseScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi


class DetailScreen :
    BaseScreen<DetailScreenModel, DetailUIState, DetailUIEffect, DetailInteractionListener>() {

    @Composable
    override fun Content() {

        initScreen(getScreenModel())

    }

    @OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
    @Composable
    override fun onRender(state: DetailUIState, listener: DetailInteractionListener) {

        Box(Modifier.fillMaxSize().background(color = Color.DarkGray)) {


        }

    }


    override fun onEffect(effect: DetailUIEffect, navigator: Navigator) {

//        when (effect) {
//            DetailUIEffect.NavigateToDetail -> navigator.root?.push(DashBoardScreen())
//        }
    }
}