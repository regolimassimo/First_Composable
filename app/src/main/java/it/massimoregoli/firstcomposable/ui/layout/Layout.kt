package it.massimoregoli.firstcomposable.ui.layout

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import it.massimoregoli.firstcomposable.model.MyModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
@Composable
fun TheLayout(myModel: MyModel) {
    when(ScreenRouter.currentScreen.value) {
        1 -> MainLayout(myModel)
        2 -> InsertText(myModel)
    }
}

@Composable
fun MainLayout(myModel: MyModel) {
    Column {
        Text(text = myModel.text)
        Column(modifier= Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                onClick = {
                    myModel.color = Color.Red
                    ScreenRouter.navigateTo(2)
//            model.value = Model(2, model.value.text, Color.Red)
            }) {
                Text("Red")
            }
            Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                onClick = {
                    myModel.color = Color.Green
                    ScreenRouter.navigateTo(2)
            }) {
                Text("Green")
            }
            Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                onClick = {
                    myModel.color = Color.Blue
                    ScreenRouter.navigateTo(2)
            }) {
                Text("Blue")
            }
        }
    }
}

@Composable
fun InsertText(myModel: MyModel) {
    Column{
        OutlinedTextField(value = myModel.text, onValueChange = {
            myModel.text = it
        })
        Button(colors = ButtonDefaults.buttonColors(backgroundColor = myModel.color),
            onClick = {
                ScreenRouter.navigateTo(1)
            }
        ) {
            Text("Ok")
        }

    }
    BackButtonHandler {
        ScreenRouter.navigateTo(1)
    }
}