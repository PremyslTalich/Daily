package cz.talich.daily.system

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cz.talich.daily.R

val fontFamily = FontFamily(
    Font(R.font.josefinslab_bold, FontWeight.Bold),
    Font(R.font.josefinslab_medium, FontWeight.Medium),
    Font(R.font.josefinslab_regular, FontWeight.Normal),
    Font(R.font.josefinslab_thin, FontWeight.Thin),
)

val Typography = Typography(
    h2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    )
)