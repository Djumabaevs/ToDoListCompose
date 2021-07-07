package com.example.todolistcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.example.todolistcompose.domain.model.NoteModel


@Composable
@ExperimentalMaterialApi
private fun Content(
    notes: List<NoteModel>,
    onNoteClick: (NoteModel) -> Unit,
    selectedNotes: List<NoteModel>,
) {
    val tabs = listOf("REGULAR", "CHECKABLE")

    // Init state for selected tab
    var selectedTab by remember { mutableStateOf(0) }

    Column {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = selectedTab == index,
                    onClick = { selectedTab = index }
                )
            }
        }

        val filteredNotes = when (selectedTab) {
            0 -> {
                notes.filter { it.isCheckedOff == null }
            }
            1 -> {
                notes.filter { it.isCheckedOff != null }
            }
            else -> throw IllegalStateException("Tab not supported - index: $selectedTab")
        }

        LazyColumn {
            items(count = filteredNotes.size) { noteIndex ->
                val note = filteredNotes[noteIndex]
                val isNoteSelected = selectedNotes.contains(note)
                Note(
                    note = note,
                    onNoteClick = onNoteClick,
                    isSelected = isNoteSelected
                )
            }
        }
    }
}


private fun mapDialogTitle(dialog: Int): String = when (dialog) {
    RESTORE_NOTES_DIALOG -> "Restore notes"
    PERMANENTLY_DELETE_DIALOG -> "Delete notes forever"
    else -> throw RuntimeException("Dialog not supported: $dialog")
}

private fun mapDialogText(dialog: Int): String = when (dialog) {
    RESTORE_NOTES_DIALOG -> "Are you sure you want to restore selected notes?"
    PERMANENTLY_DELETE_DIALOG -> "Are you sure you want to delete selected notes permanently?"
    else -> throw RuntimeException("Dialog not supported: $dialog")
}
