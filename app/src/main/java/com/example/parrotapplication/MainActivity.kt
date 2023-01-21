package com.example.parrotapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parrotapplication.model.ParrotsViewModel
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme
import com.example.parrotapplication.ui.feed.Feed
import com.example.parrotapplication.ui.profile.ParrotProfile

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: ParrotsViewModel by viewModels()
        setContent {
            ParrotApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: ParrotsViewModel) {
    val state by viewModel.parrots.collectAsState()
    var selectedId by remember {
        mutableStateOf<String?>(value = null)
    }
    Crossfade(targetState = selectedId) { id ->
        if (id == null) {
            Feed(parrots = state, onSelected = { parrot ->
                selectedId = parrot.id
            })
        } else {
            ParrotProfile(
                parrot = viewModel.getById(id),
            )
            BackHandler() {
                selectedId = null
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ParrotApplicationTheme {
        MainScreen(ParrotsViewModel())
    }
}
