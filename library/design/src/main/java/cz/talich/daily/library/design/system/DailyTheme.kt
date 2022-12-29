package cz.talich.daily.library.design.system

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object DailyTheme {
    val typography: Typography = Typography
    val shapes: Shapes = Shapes
    val colors: Colors = lightColors(
        background = Color.Black,
        onBackground = Color.White
    )
}

@Composable
fun DailyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DailyTheme.colors,
        typography = DailyTheme.typography,
        shapes = DailyTheme.shapes,
        content = content
    )
}
