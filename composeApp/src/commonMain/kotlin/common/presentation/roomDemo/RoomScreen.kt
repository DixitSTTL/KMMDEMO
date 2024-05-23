package common.presentation.roomDemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import common.data.model.DataEmployee
import common.presentation.base.BaseScreen
import fontResources
import getPlatform
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


class RoomScreen :
    BaseScreen<RoomScreenModel, RoomUIState, RoomUIEffect, RoomInteractionListener>() {

    @Composable
    override fun Content() {
        initScreen(getScreenModel())

    }

    @Composable
    override fun onRender(state: RoomUIState, listener: RoomInteractionListener) {

        Box(Modifier.fillMaxSize().background(color = Color(0xffffffff))) {

            if (getPlatform().name.startsWith("A")) {
                LazyColumn(Modifier.padding(20.dp, 0.dp)) {

                    item {
                        Column {

                            TextFieldContainer(state.txtName, "enter name") {
                                listener.updateName(it)
                            }

                            Spacer(Modifier.height(12.dp))

                            TextFieldContainer(state.txtDepartment, "enter department") {
                                listener.updateDepartment(it)
                            }

                            Spacer(Modifier.height(12.dp))

                            ButtonsContainer(listener)

                        }
                    }

                    items(state.allEmployee) {
                        RoomItem(it, listener)

                    }
                }

            } else {

                Row(Modifier.padding(20.dp, 0.dp)) {
                    Column(Modifier.weight(1f)) {
                        TextFieldContainer(
                            state.txtName, "enter name"
                        ) {
                            listener.updateName(it)
                        }

                        Spacer(Modifier.height(12.dp))

                        TextFieldContainer(
                            state.txtDepartment, "enter department"
                        ) {
                            listener.updateDepartment(it)
                        }

                        Spacer(Modifier.height(12.dp))

                        ButtonsContainer(listener)

                    }

                    Spacer(Modifier.width(12.dp))

                    LazyColumn(Modifier.weight(1f)) {
                        item {
                            Text(
                                text = state.latestUser, style = TextStyle(
                                    fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                                    fontSize = 26.sp,
                                    color = Color(0xff2C2B34)
                                )
                            )
                        }

                        items(state.allEmployee) {
                            RoomItem(it, listener)

                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun TextFieldContainer(
        string: String,
        placeholder: String,
        valueChangeFun: (String) -> Unit
    ) {
        TextField(
            value = string,
            onValueChange = valueChangeFun,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(
                    text = placeholder, style = TextStyle(
                        fontFamily = FontFamily(fontResources("barlow_medium")),
                        fontSize = 18.sp,
                        color = Color(0xff535163)
                    )
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily(fontResources("barlow_medium")),
                fontSize = 18.sp,
                color = Color(0xff2C2B34)

            ),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                cursorColor = Color.Black
            )
        )
    }

    @Composable
    private fun ButtonsContainer(listener: RoomInteractionListener) {
        Row(modifier = Modifier.fillMaxWidth()) {

            Button(
                onClick = { listener.addToDataBase() }, colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black, backgroundColor = Color.Black
                ), shape = RoundedCornerShape(50), modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Add", style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                    ), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center

                )

            }

            Spacer(Modifier.width(6.dp))

            Button(
                onClick = { listener.deleteAll() }, colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black, backgroundColor = Color.Black
                ), shape = RoundedCornerShape(50), modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Delete All", style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                    ), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center

                )

            }
        }
    }


    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun RoomItem(it: DataEmployee, listener: RoomInteractionListener) {
        Card(
            modifier = Modifier.padding(0.dp, 10.dp).fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = 6.dp
        ) {
            Box(Modifier.padding(12.dp)) {
                Column() {

                    Text(
                        text = it.name, style = TextStyle(
                            fontFamily = FontFamily(fontResources("barlow_semi_bold")),
                            fontSize = 18.sp,
                            color = Color(0xff2C2B34)
                        )
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = it.department, style = TextStyle(
                            fontFamily = FontFamily(fontResources("barlow_regular")),
                            color = Color(0xff535163)
                        )
                    )
                }

                Image(painter = painterResource(resource = DrawableResource("ic_delete.xml")), "",
                    modifier = Modifier.align(Alignment.CenterEnd).clickable {
                        listener.deleteById(it.id)
                    })

            }
        }
    }

    override fun onEffect(effect: RoomUIEffect, navigator: Navigator) {


    }
}