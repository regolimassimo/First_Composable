package it.massimoregoli.firstcomposable.ui.layout

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.massimoregoli.firstcomposable.model.MyModel


@Composable
fun MainLayout(myModel: MyModel) {
    Column {
        if(myModel.text != "") {
            Text(text = "You wrote: ${myModel.text}",
                fontSize = 32.sp)
        }
        ButtonNavigators(myModel)
    }
}

@Composable
fun ButtonNavigators(myModel: MyModel) {
    Row(modifier= Modifier
        .fillMaxHeight()
        .fillMaxWidth().
        padding(4.dp),
        horizontalArrangement = Arrangement.SpaceAround) {
        Button(colors = ButtonDefaults
            .buttonColors(backgroundColor = Color.Red),
            onClick = {
                myModel.color = Color.Red
                ScreenRouter.navigateTo(2)
            }) {
            Text("Red", fontSize = 32.sp)
        }
        Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
            onClick = {
                myModel.color = Color.Green
                ScreenRouter.navigateTo(2)
            }) {
            Text("Green", fontSize = 32.sp)
        }
        Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
            onClick = {
                myModel.color = Color.Blue
                ScreenRouter.navigateTo(2)
            }) {
            Text("Blue", fontSize = 32.sp)
        }
    }
}

@Composable
fun InsertText(myModel: MyModel) {
    val testo = rememberSaveable() {
        mutableStateOf("")
    }
    Column{
        OutlinedTextField(value = testo.value,
            onValueChange = {
            testo.value = it
        }, textStyle = LocalTextStyle.current.copy(fontSize=32.sp),
        label = {
            Text("Scrivi", fontSize = 24.sp)
        },
        modifier = Modifier.fillMaxWidth().padding(16.dp))

        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End) {
            Button(modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = myModel.color),
                onClick = {
                    myModel.text = testo.value
                    ScreenRouter.navigateTo(1)
                }
            ) {
                Text("Ok", fontSize = 32.sp)
            }
        }
        BackHandler {
            ScreenRouter.navigateTo(1)
        }
    }
}