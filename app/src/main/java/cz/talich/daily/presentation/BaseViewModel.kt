package cz.talich.daily.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<S>(initialState: S) : ViewModel() {
    private val mutableStates: MutableStateFlow<S> = MutableStateFlow(initialState)
    val states: StateFlow<S> = mutableStates.asStateFlow()

    var state: S
        get() = states.value
        protected set(value) {
            mutableStates.value = value
        }
}