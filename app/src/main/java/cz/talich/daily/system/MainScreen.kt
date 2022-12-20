package cz.talich.daily.system

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import cz.talich.daily.presentation.MainViewModel


@Composable
fun MainScreen(closeApp: () -> Unit) {
    val viewModel: MainViewModel = viewModel()
    val state by viewModel.states.collectAsState()

    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isSystemBarsVisible = false

    if (state.shouldCloseApp) {
        closeApp()
    }

    DailyTheme {
        Scaffold(
            scaffoldState = rememberScaffoldState()
        ) {
            Message(state)
        }
    }
}

@Composable
fun Message(
    state: MainViewModel.State
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Line("Everything", state.isFirstLineVisible)
        Line("Will", state.isSecondLineVisible)
        Line("Be", state.isThirdLineVisible)
        Line("Alright", state.isFourthLineVisible)
    }
}

@Composable
fun Line(message: String, isVisible: Boolean) {
    val color = remember { Animatable(Color.Transparent) }

    if (isVisible) {
        LaunchedEffect(Unit) {
            color.animateTo(DailyTheme.colors.onBackground, animationSpec = tween(1000))
        }
    }

    Text(
        text = message,
        style = DailyTheme.typography.h2,
        color = color.value
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DailyTheme {
        Message(
            MainViewModel.State(
                isFirstLineVisible = true,
                isSecondLineVisible = true,
                isThirdLineVisible = true
            )
        )
    }
}
