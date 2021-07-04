package com.example.todolistcompose.ui.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@ExperimentalMaterialApi
@Preview
@Composable
private fun NotePreview() {
    Note(note = NoteModel(1, "Note 1", "Content 1", null), isSelected = false)
}