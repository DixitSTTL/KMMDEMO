package common.presentation.ktorDemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import common.presentation.base.BaseScreen
import fontResources
import getPlatform


class KtorScreen :
    BaseScreen<KtorScreenModel, KtorUIState, KtorUIEffect, KtorInteractionListener>() {

    @Composable
    override fun Content() {
        initScreen(getScreenModel())

    }

    @Composable
    override fun onRender(state: KtorUIState, listener: KtorInteractionListener) {

        LaunchedEffect(true) {
            listener.getContinents()
        }
        Box(Modifier.fillMaxSize().background(color = Color(0xffffffff))) {

            if (state.isLoading) {
                CircularProgressIndicator(
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                if (getPlatform().name.startsWith("A")) {
                    LazyColumn(Modifier.padding(10.dp, 0.dp)) {


                        items(state.continents) {
                            KtorItem(it)

                        }
                    }

                } else {
                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Fixed(3),
                        Modifier.padding(20.dp, 0.dp)
                    ) {


                        items(state.continents) {
                            KtorItem(it)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun KtorItem(it: String) {
        Box(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = 6.dp,
            ) {
                Column(Modifier.padding(12.dp)) {

                    Text(
                        text = it, style = TextStyle(
                            fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                            fontSize = 18.sp,
                            color = Color(0xff2C2B34)
                        )
                    )
                }
            }
        }
    }

    override fun onEffect(effect: KtorUIEffect, navigator: Navigator) {

    }
}