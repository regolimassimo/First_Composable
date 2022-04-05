package it.massimoregoli.firstcomposable.model


import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class MyModel: Parcelable {
//    @IgnoredOnParcel
//    private var _layout = mutableStateOf(1)
//    var layout: Int
//    get() {
//        return _layout.value
//    }
//    set(value) {
//        _layout.value = value
//    }

    @IgnoredOnParcel
    private var _text = mutableStateOf("")
    var text: String
    get() {
        return _text.value
    }
    set(value) {
        _text.value = value
    }

    @IgnoredOnParcel
    private var _color = mutableStateOf(Color.Red)
    var color: Color
    get() {
        return _color.value
    }
    set(value) {
        _color.value = value
    }
}