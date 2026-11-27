package com.misterfrog.weatherwiseai.core.designsystem.tokens

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontWeight

internal object AppTypography {
    private val materialTypography = Typography()

    val heroTitle = materialTypography.headlineLarge.copy(
        fontWeight = FontWeight.Bold
    )

    val screenTitle = materialTypography.headlineMedium.copy(
        fontWeight = FontWeight.Bold
    )

    val sectionTitle = materialTypography.titleLarge.copy(
        fontWeight = FontWeight.SemiBold
    )

    val cardTitle = materialTypography.titleMedium.copy(
        fontWeight = FontWeight.SemiBold
    )

    val body = materialTypography.bodyLarge

    val supporting = materialTypography.bodyMedium

    val caption = materialTypography.bodySmall

    val buttonLabel = materialTypography.labelLarge.copy(
        fontWeight = FontWeight.SemiBold
    )
}
