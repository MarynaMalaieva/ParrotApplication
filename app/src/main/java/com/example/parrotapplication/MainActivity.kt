package com.example.parrotapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.parrotapplication.model.ParrotsViewModel
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme
import com.example.parrotapplication.ui.theme.feed.Feed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ViewModel: ParrotsViewModel by viewModels()
        setContent {
            ParrotApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(ViewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: ParrotsViewModel){
    val state by viewModel.parrots.collectAsState()
    Feed(parrots = state, onSelected = {})
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ParrotApplicationTheme {
        MainScreen(ParrotsViewModel())
    }
}