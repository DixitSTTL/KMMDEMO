package common.presentation.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import common.presentation.base.BaseScreen
import common.presentation.dashboard.DashBoardScreen
import common.presentation.ktorDemo.KtorScreen
import common.presentation.roomDemo.RoomScreen
import fontResources
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


class WelcomeScreen :
    BaseScreen<WelcomeScreenModel, WelcomeUIState, WelcomeUIEffect, WelcomeInteractionListener>() {

    @Composable
    override fun Content() {

        initScreen(getScreenModel())

    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun onRender(state: WelcomeUIState, listener: WelcomeInteractionListener) {


        LaunchedEffect(true) {
            delay(600)
            listener.onShowContent(!state.showContent)
        }

        Box(Modifier.fillMaxSize().background(color = Color(0xff232325))) {
            AnimatedVisibility(state.showContent) {
                Image(
                    painterResource(resource = DrawableResource("car1.png")),
                    null,

                    )
            }
            Column(
                Modifier.align(Alignment.BottomCenter).padding(20.dp, 20.dp, 20.dp, 40.dp),
            ) {

                Text(
                    text = "Premium cars.\n" +
                            "Enjoy the luxury",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 26.sp,
                        fontFamily = FontFamily(fontResources("barlow_bold")),
                    ),
                )

                Spacer(Modifier.height(10.dp))

                Text(
                    text = "Premium and prestige car daily rental.Experience the thrill at a lower price",
                    style = TextStyle(
                        color = Color(0xff8E8E8E),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(fontResources("barlow_medium")),
                    ),
                )

                Spacer(Modifier.height(30.dp))

                Button(
                    onClick = { listener.onClickToHome() },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        backgroundColor = Color.White
                    ),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Let's Go",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center

                    )

                }

                Spacer(Modifier.height(12.dp))

                Button(
                    onClick = { listener.onClickToKtor() },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        backgroundColor = Color.White
                    ),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Ktor Demo",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center

                    )

                }

                Spacer(Modifier.height(12.dp))

                Button(
                    onClick = { listener.onClickToRoom() },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        backgroundColor = Color.White
                    ),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Room Demo",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center

                    )

                }

            }
        }
    }


    override fun onEffect(effect: WelcomeUIEffect, navigator: Navigator) {

        when (effect) {
            WelcomeUIEffect.NavigateToDashBoard -> navigator.push(DashBoardScreen())
            WelcomeUIEffect.NavigateToRoom -> navigator.push(RoomScreen())
            WelcomeUIEffect.NavigateToKtor -> navigator.push(KtorScreen())
        }
    }
}