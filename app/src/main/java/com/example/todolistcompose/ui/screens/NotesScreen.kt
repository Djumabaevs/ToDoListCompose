package com.example.todolistcompose.ui.screens

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolistcompose.domain.model.NoteModel


@ExperimentalMaterialApi
@Preview
@Composable
private fun NotesListPreview() {
    NotesList(
        notes = listOf(
            NoteModel(1, "Note 1", "Content 1", null),
            NoteModel(2, "Note 2", "Content 2", false),
            NoteModel(3, "Note 3", "Content 3", true)
        ),
        onNoteCheckedChange = {},
        onNoteClick = {}
    )
}