package com.example.todolistcompose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Composable
fun JetNotesTheme(content: @Composable () -> Unit) {
    val isDarkThemeEnabled = isSystemInDarkTheme() || JetNotesThemeSettings.isDarkThemeEnabled
    val colors = if (isDarkThemeEnabled) DarkThemeColors else LightThemeColors

    MaterialTheme(colors = colors, content = content)
}

/**
 * Allows changing between light and a dark theme from the app's settings.
 */
object JetNotesThemeSettings {
    var isDarkThemeEnabled by mutableStateOf(false)
}
