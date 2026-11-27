package com.misterfrog.weatherwiseai.features.home.presentation.model

internal data class HourlyForecastUiModel(
    val id: String,
    val time: String,
    val temperature: String,
    val condition: String
)
