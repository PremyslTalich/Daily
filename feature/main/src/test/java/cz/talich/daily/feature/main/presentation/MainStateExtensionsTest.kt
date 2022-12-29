package cz.talich.daily.feature.main.presentation

import io.kotest.matchers.shouldBe
import org.junit.Test

internal class MainStateExtensionsTest {
    private val state = MainViewModel.State()

    @Test
    fun `should reveal first line`() {
        state.revealFirstLine().isFirstLineVisible shouldBe true
    }

    @Test
    fun `should reveal second line`() {
        state.revealSecondLine().isSecondLineVisible shouldBe true
    }

    @Test
    fun `should reveal third line`() {
        state.revealThirdLine().isThirdLineVisible shouldBe true
    }

    @Test
    fun `should close the app`() {
        state.closeApp().shouldCloseApp shouldBe true
    }
}
