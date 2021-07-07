package com.example.todolistcompose.ui.screens




private fun mapDialogText(dialog: Int): String = when (dialog) {
    RESTORE_NOTES_DIALOG -> "Are you sure you want to restore selected notes?"
    PERMANENTLY_DELETE_DIALOG -> "Are you sure you want to delete selected notes permanently?"
    else -> throw RuntimeException("Dialog not supported: $dialog")
}
