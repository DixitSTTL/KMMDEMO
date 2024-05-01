package common.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import common.data.model.DataMoreCars
import common.presentation.base.BaseScreen
import common.presentation.detail.DetailScreen
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
                Modifier.padding(20.dp, 0.dp).verticalScroll(rememberScrollState()),
            ) {

                Row(modifier = Modifier.fillMaxWidth()) {

                    Button(
                        {},
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Transparent,
                            backgroundColor = Color.Transparent
                        ),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp
                        ),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Image(
                            painterResource("ic_info.xml"),
                            ""
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Information", style = TextStyle(
                                color = Color(0xff2C2B34),
                                fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                            )
                        )

                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Button(
                        {},
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Transparent,
                            backgroundColor = Color.Transparent
                        ),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp
                        ),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.weight(1f)

                    ) {
                        Image(
                            painterResource("ic_bell.xml"),
                            ""
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Notifications", style = TextStyle(
                                color = Color(0xff2C2B34),
                                fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                            )
                        )

                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    shape = RoundedCornerShape(20.dp),
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
                            painter = painterResource(state.currentModel.image),
                            contentDescription = "",
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        Spacer(Modifier.height(10.dp))

                        Text(
                            text = state.currentModel.name, style = TextStyle(
                                color = Color(0xff2C2B34),
                                fontSize = 18.sp,
                                fontFamily = FontFamily(fontResources("barlow_bold")),
                            )
                        )

                        Spacer(Modifier.height(6.dp))

                        Row(
                            modifier = Modifier.padding(0.dp, 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource("ic_gps2.xml"),
                                contentDescription = "",

                                )
                            Text(
                                text = "${state.currentModel.kms}Km",
                                fontFamily = FontFamily(fontResources("barlow_regular")),
                                style = TextStyle(
                                    color = Color(0xff787878),
                                ),
                                modifier = Modifier.padding(6.dp, 0.dp)
                            )

                            Spacer(Modifier.width(14.dp))


                            Image(
                                painter = painterResource("ic_gas_pump2.xml"),
                                contentDescription = "",

                                )

                            Text(
                                text = "${state.currentModel.fule}",
                                fontFamily = FontFamily(fontResources("barlow_regular")),
                                style = TextStyle(
                                    color = Color(0xff787878),
                                ),
                                modifier = Modifier.padding(6.dp, 0.dp, 0.dp, 0.dp)
                            )
                            Text(
                                text = if (state.currentModel.isEv) "%" else "L",
                                fontFamily = FontFamily(fontResources("barlow_regular")),
                                style = TextStyle(
                                    color = Color(0xff787878),
                                )
                            )

                            Text(
                                text = "$ 45,00/h",
                                fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.End
                            )
                        }
                    }

                }

                Spacer(Modifier.height(12.dp))

                Row(modifier = Modifier.height(IntrinsicSize.Min)) {

                    Card(
                        shape = RoundedCornerShape(20.dp),
                        backgroundColor = Color(0xffF3F3F3),
                        modifier = Modifier.weight(1f),
                    ) {


                        Column(
                            modifier = Modifier.padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {


                            Image(
                                painter = painterResource("user.png"),
                                contentDescription = "",
                            )

                            Spacer(Modifier.height(8.dp))

                            Text(
                                text = "Jane Cooper", style = TextStyle(
                                    color = Color(0xff2C2B34),
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily(fontResources("barlow_bold")),
                                )
                            )

                            Spacer(Modifier.height(4.dp))

                            Text(
                                text = "$ 4,253", style = TextStyle(
                                    color = Color(0xff2C2B34),
                                    fontFamily = FontFamily(fontResources("barlow_bold")),
                                )
                            )
                        }

                    }

                    Spacer(modifier = Modifier.width(10.dp))


                    Card(
                        shape = RoundedCornerShape(20.dp),
                        backgroundColor = Color(0xffF3F3F3),
                        modifier = Modifier.weight(1f)

                    ) {
                        Image(
                            painter = painterResource("map.png"),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.clickable {
                                listener.onClickToDetail()
                            }
                        )
                    }
                }

                Spacer(Modifier.height(12.dp))

                Card(
                    shape = RoundedCornerShape(20.dp),
                    backgroundColor = Color(0xff282931),
                ) {


                    Column(modifier = Modifier.padding(20.dp)) {

                        Text(
                            text = "More Cars",
                            style = TextStyle(
                                color = Color(0xffD4D4D4),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(fontResources("barlow_light")),
                            ),
                        )


                        state.getMoreCars.forEachIndexed { i, it ->
                            ItemMoreCars(it, listener)
                            if (i + 1 < state.getMoreCars.size) {

                                Spacer(
                                    modifier = Modifier.fillMaxWidth().height(0.5.dp)
                                        .background(Color.White)
                                )
                            }
                        }


                    }

                }

                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun ItemMoreCars(model: DataMoreCars, listener: DashBoardInteractionListener) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(0.dp, 8.dp).clickable {
                listener.updateCurrentModel(model)

            },
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = model.name,
                    fontFamily = FontFamily(fontResources("barlow_bold")),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    )
                )

                Row(
                    modifier = Modifier.padding(0.dp, 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource("ic_gps.xml"),
                        contentDescription = "",

                        )
                    Text(
                        text = "${model.kms}Km",
                        fontFamily = FontFamily(fontResources("barlow_regular")),
                        style = TextStyle(
                            color = Color.White,
                        ),
                        modifier = Modifier.padding(6.dp, 0.dp)
                    )

                    Spacer(Modifier.width(14.dp))


                    Image(
                        painter = painterResource(if (model.isEv) "ic_battery.xml" else "ic_gas_pump.xml"),
                        contentDescription = "",

                        )

                    Text(
                        text = model.fule,
                        fontFamily = FontFamily(fontResources("barlow_regular")),
                        style = TextStyle(
                            color = Color.White,
                        ),
                        modifier = Modifier.padding(6.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Text(
                        text = if (model.isEv) "%" else "L",
                        fontFamily = FontFamily(fontResources("barlow_regular")),
                        style = TextStyle(
                            color = Color.White,
                        )
                    )
                }


            }

            Image(
                painter = painterResource("ic_arrow_left.xml"),
                contentDescription = "",
                modifier = Modifier.size(32.dp)
                    .background(shape = RoundedCornerShape(50), color = Color.White)
                    .padding(6.dp)
            )


        }


    }


    override fun onEffect(effect: DashBoardUIEffect, navigator: Navigator) {

        when (effect) {
            DashBoardUIEffect.NavigateToDetail -> navigator.push(DetailScreen())
        }
    }
}