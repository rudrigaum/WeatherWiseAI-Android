
package com.misterfrog.weatherwiseai.core.designsystem.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misterfrog.weatherwiseai.core.designsystem.tokens.AppShapes
import com.misterfrog.weatherwiseai.core.designsystem.tokens.AppSpacing
import com.misterfrog.weatherwiseai.ui.theme.WeatherWiseAITheme

@Composable
internal fun AppCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = AppShapes.card,
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 4.dp
    ) {
        Box(
            modifier = Modifier.padding(AppSpacing.medium)
        ) {
            content()
        }
    }
}

@Preview(
    name = "App Card - Light",
    showBackground = true
)
@Preview(
    name = "App Card - Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun AppCardPreview() {
    WeatherWiseAITheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(AppSpacing.medium),
            verticalArrangement = Arrangement.spacedBy(
                AppSpacing.medium
            )
        ) {
            AppCard {
                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        AppSpacing.xSmall
                    )
                ) {
                    Text(
                        text = "Weather Forecast",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "Weather information will appear here.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            AppCard {
                Text(
                    text = "Plan your next activity",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
