package it.massimoregoli.firstcomposable.model

import android.os.Parcelable
import androidx.compose.runtime.mutableStateOf
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class MyCounterModel: Parcelable {
    @IgnoredOnParcel
    private var _counter = mutableStateOf(0)
    var counter: Int
    get() {
        return _counter.value
    }
    set(value) {
        _counter.value = value
    }

    fun add() {
        _counter.value = _counter.value + 1
    }
}