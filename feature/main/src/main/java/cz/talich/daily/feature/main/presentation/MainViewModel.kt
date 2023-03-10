package cz.talich.daily.feature.main.presentation

import androidx.lifecycle.viewModelScope
import cz.talich.daily.feature.main.infrastructure.DelayService
import cz.talich.daily.library.mvvm.presentation.AbstractViewModel
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class MainViewModel : AbstractViewModel<MainViewModel.State>(State()) {
    init {
        viewModelScope.launch {
            DelayService.delay(1.seconds)

            state = state.revealFirstLine()
            DelayService.delay(1.seconds)

            state = state.revealSecondLine()
            DelayService.delay(1.2.seconds)

            state = state.revealThirdLine()
            DelayService.delay(3.seconds)

            state = state.closeApp()
        }
    }

    data class State(
        val shouldCloseApp: Boolean = false,
        val isFirstLineVisible: Boolean = false,
        val isSecondLineVisible: Boolean = false,
        val isThirdLineVisible: Boolean = false
    )
}
