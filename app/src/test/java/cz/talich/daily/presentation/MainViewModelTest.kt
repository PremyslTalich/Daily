package cz.talich.daily.presentation

import cz.talich.daily.infrastructure.DelayService
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockkObject
import io.mockk.runs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import kotlin.time.Duration.Companion.seconds

internal class MainViewModelTest {
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `default view state should have all the lines hidden`() {
        MainViewModel.State() shouldBe MainViewModel.State(
            shouldCloseApp = false,
            isFirstLineVisible = false,
            isSecondLineVisible = false,
            isThirdLineVisible = false,
            isFourthLineVisible = false
        )
    }

    @Test
    fun `should reveal all lines and them close the app in the right order and with correct timing`() {
        mockkObject(DelayService)
        coEvery { DelayService.delay(1.seconds) } just runs
        coEvery { DelayService.delay(1.2.seconds) } just runs
        coEvery { DelayService.delay(3.seconds) } just runs

        val viewModel = MainViewModel()

        coVerify {
            DelayService.delay(1.seconds)

            viewModel.state.revealFirstLine()
            DelayService.delay(1.seconds)

            viewModel.state.revealSecondLine()
            DelayService.delay(1.2.seconds)

            viewModel.state.revealThirdLine()
            viewModel.state.revealFourthLine()
            DelayService.delay(3.seconds)

            viewModel.state.closeApp()
        }
    }
}