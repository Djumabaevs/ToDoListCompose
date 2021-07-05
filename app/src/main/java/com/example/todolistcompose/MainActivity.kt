package com.example.todolistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolistcompose.routing.JetNotesRouter
import com.example.todolistcompose.routing.Screen
import com.example.todolistcompose.theme.JetNotesTheme
import com.example.todolistcompose.ui.screens.NotesScreen
import com.example.todolistcompose.ui.screens.SaveNoteScreen
import com.example.todolistcompose.ui.theme.ToDoListComposeTheme
import com.example.todolistcompose.viewmodel.MainViewModel
import com.example.todolistcompose.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels(factoryProducer = {
        MainViewModelFactory(
            this,
            (application as ToDoApplication).dependencyInjector.repository
        )
    })

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetNotesTheme {
                MainActivityScreen(viewModel = viewModel) // here
            }
        }
    }
}

@Composable
@ExperimentalMaterialApi
private fun MainActivityScreen(viewModel: MainViewModel) {
    Surface {
        when (JetNotesRouter.currentScreen) {
            is Screen.Notes -> NotesScreen(viewModel)
            is Screen.SaveNote -> SaveNoteScreen(viewModel)
            is Screen.Trash -> TrashScreen(viewModel)
        }
    }
}