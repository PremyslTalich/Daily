package cz.talich.daily.library.mvvm.presentation

import app.cash.turbine.test
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class BaseViewModelTest {
    @Test
    fun `should set the initial view state and provide it`() {
        val initialState = "initial state"
        val viewModel = object : AbstractViewModel<String>(initialState) {}
        viewModel.state shouldBe initialState
    }
    @Test
    fun testStatesProperty() = runTest {
        val initialState = "initial state"
        val viewModel = TestViewModel(initialState)

        viewModel.states.test {
            awaitItem() shouldBe "initial state"
            viewModel.newState()
            awaitItem() shouldBe "new state"
        }
    }

    class TestViewModel(initialState: String) : AbstractViewModel<String>(initialState) {
        fun newState() {
            state = "new state"
        }
    }
}
