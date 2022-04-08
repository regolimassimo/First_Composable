package it.massimoregoli.firstcomposable.ui.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import it.massimoregoli.firstcomposable.model.MyModel

object ScreenRouter {
    var currentScreen: MutableState<Int> = mutableStateOf(1)

    fun navigateTo(destination: Int) {
        currentScreen.value = destination
    }
}

@Composable
fun TheLayout() {
    val myModel = rememberSaveable {
        MyModel()
    }

    when(ScreenRouter.currentScreen.value) {
        1 -> MainLayout(myModel)
        2 -> InsertText(myModel)
    }
}