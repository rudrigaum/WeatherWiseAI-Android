
package com.misterfrog.weatherwiseai.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.misterfrog.weatherwiseai.core.designsystem.tokens.AppColors

private val LightColorScheme = lightColorScheme(
    primary = AppColors.brandPrimary,
    onPrimary = AppColors.onBrandPrimary,
    secondary = AppColors.brandSecondary,
    onSecondary = AppColors.onBrandPrimary,
    background = AppColors.screenBackground,
    onBackground = AppColors.textPrimary,
    surface = Color.White,
    onSurface = AppColors.textPrimary
)

private val DarkColorScheme = darkColorScheme(
    primary = AppColors.brandPrimary,
    onPrimary = AppColors.onBrandPrimary,
    secondary = AppColors.brandSecondary,
    onSecondary = AppColors.onBrandPrimary
)

@Composable
fun WeatherWiseAITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current

            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
