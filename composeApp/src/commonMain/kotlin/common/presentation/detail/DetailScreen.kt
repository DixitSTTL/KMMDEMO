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
import domain.entity.Location
import org.jetbrains.compose.resources.ExperimentalResourceApi
import presentation.map.CalfMapWebView


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

            CalfMapWebView(
                modifier = Modifier.fillMaxSize(),
                url = MAP_URL,
                currentLocation = Location(21.7644725, 72.15193040000001, "Bhavnagar"),
                destination = Location(22.3038945, 70.80215989999999, "Rajkot"),
            )
        }

    }


    override fun onEffect(effect: DetailUIEffect, navigator: Navigator) {

//        when (effect) {
//            DetailUIEffect.NavigateToDetail -> navigator.root?.push(DashBoardScreen())
//        }
    }

    companion object {
        private const val MAP_URL = "File:///android_asset/bing_map/map/index.html"
    }
}