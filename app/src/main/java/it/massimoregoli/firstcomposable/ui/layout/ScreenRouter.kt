package it.massimoregoli.firstcomposable.ui.layout

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object ScreenRouter {
    var currentScreen: MutableState<Int> = mutableStateOf(1)

    fun navigateTo(destination: Int) {
        currentScreen.value = destination
    }
}