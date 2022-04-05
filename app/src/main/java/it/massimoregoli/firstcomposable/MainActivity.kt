package it.massimoregoli.firstcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import it.massimoregoli.firstcomposable.ui.theme.FirstComposableTheme
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import it.massimoregoli.firstcomposable.model.MyCounterModel
import it.massimoregoli.firstcomposable.model.MyModel
import it.massimoregoli.firstcomposable.ui.layout.TheLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val myModel = rememberSaveable() {
                MyModel()
            }
//            val myModel = MyModel()

            TheLayout(myModel)
        }
    }
}


@Composable
fun Hello() {
    val name = rememberSaveable { MyCounterModel() }
    Screen1(name, onNameChange = { name.add() })
}

@Composable
fun Screen1(name: MyCounterModel, onNameChange: () -> Unit) {
    Column {
        Text(
            text = name.counter.toString(),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(8.dp)
                .border(2.dp, Color.Red, RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.End
        )
        Button(onClick = { onNameChange() }) {
            Text("Add 1")
        }
    }
}


@Composable
fun Screen0() {
    val name = rememberSaveable { MyCounterModel() }
    Column {
        Text(
            text = name.counter.toString(),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(8.dp)
                .border(2.dp, Color.Red, RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.End
        )
        Button(onClick = { name.add() }) {
            Text("Add 1")
        }
    }
}

@Composable
fun Greeting() {
    Column(modifier = Modifier.padding(16.dp)) {
        var name = rememberSaveable {
            mutableStateOf("")
        }
//        var name by remember { mutableStateOf("") }

        if (name.value.isNotEmpty()) {
            Text(
                text = "Hello, ${name.value}!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Your name") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
