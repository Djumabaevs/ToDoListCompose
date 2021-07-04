package com.example.todolistcompose.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolistcompose.routing.Screen
import com.example.todolistcompose.theme.JetNotesTheme


@Preview
@Composable
fun AppDrawerPreview() {
    JetNotesTheme {
        AppDrawer(Screen.Notes, {})
    }
}