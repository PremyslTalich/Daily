package cz.talich.daily.library.design.system

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cz.talich.daily.library.design.R

val fontFamily = FontFamily(
    Font(R.font.playfairdisplay_regular, FontWeight.Normal)
)

val Typography = Typography(
    h2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = 5.sp
    )
)
