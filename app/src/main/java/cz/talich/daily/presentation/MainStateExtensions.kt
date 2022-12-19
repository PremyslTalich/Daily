package cz.talich.daily.presentation

internal fun MainViewModel.State.revealFirstLine() = copy(
    isFirstLineVisible = true
)

internal fun MainViewModel.State.revealSecondLine() = copy(
    isSecondLineVisible = true
)

internal fun MainViewModel.State.revealThirdLine() = copy(
    isThirdLineVisible = true
)

internal fun MainViewModel.State.revealFourthLine() = copy(
    isFourthLineVisible = true
)

internal fun MainViewModel.State.closeApp() = copy(
    shouldCloseApp = true
)