package common.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import common.presentation.base.BaseScreen
import fontResources
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


class DashBoardScreen :
    BaseScreen<DashBoardScreenModel, DashboardUIState, DashBoardUIEffect, DashBoardInteractionListener>() {

    @Composable
    override fun Content() {

        initScreen(getScreenModel())

    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun onRender(state: DashboardUIState, listener: DashBoardInteractionListener) {


        Box(Modifier.fillMaxSize().background(color = Color(0xffffffff))) {

            Column(
                Modifier.verticalScroll(rememberScrollState()).padding(20.dp),
            ) {


                Card(
                    shape = RoundedCornerShape(12.dp),
                    backgroundColor = Color(0xffF3F3F3)

                ) {


                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "NEAREST CAR",
                            style = TextStyle(
                                color = Color(0xff787878),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(fontResources("barlow_light")),
                            ),
                        )

                        Image(
                            painter = painterResource("car3.png"),
                            contentDescription = "",
                        )

                        Spacer(Modifier.height(10.dp))

                        Text(
                            text = "Fortuner GR", style = TextStyle(
                                color = Color(0xff2C2B34),
                                fontSize = 18.sp,
                                fontFamily = FontFamily(fontResources("barlow_bold")),
                            )
                        )
                    }

                }

            }
        }
    }


    override fun onEffect(effect: DashBoardUIEffect, navigator: Navigator) {

//        when (effect) {
//            WelcomeUIEffect.NavigateToDashBoard -> navigator.root?.push(LoginScreen())
//        }
    }
}