package com.misterfrog.weatherwiseai.features.home.presentation.model

internal data class HomeUiModel(
    val greeting: String,
    val city: String,
    val temperature: String,
    val condition: String,
    val feelsLike: String,
    val precipitation: String,
    val hourlyForecast: List<HourlyForecastUiModel>,
    val suggestion: String,
    val isDemonstrationData: Boolean
)
