
package com.misterfrog.weatherwiseai.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misterfrog.weatherwiseai.core.designsystem.tokens.AppShapes
import com.misterfrog.weatherwiseai.core.designsystem.tokens.AppSpacing
import com.misterfrog.weatherwiseai.ui.theme.WeatherWiseAITheme

@Composable
internal fun AppPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp),
        enabled = enabled,
        shape = AppShapes.control,
        contentPadding = PaddingValues(
            horizontal = AppSpacing.medium,
            vertical = AppSpacing.small
        ),
        content = content
    )
}

@Preview(
    name = "Primary Button States",
    showBackground = true
)
@Composable
private fun AppPrimaryButtonPreview() {
    WeatherWiseAITheme {
        Column(
            modifier = Modifier.padding(AppSpacing.large),
            verticalArrangement = Arrangement.spacedBy(AppSpacing.medium)
        ) {
            AppPrimaryButton(
                onClick = {}
            ) {
                Text("Plan an activity")
            }

            AppPrimaryButton(
                onClick = {},
                enabled = false
            ) {
                Text("Plan an activity")
            }
        }
    }
}
