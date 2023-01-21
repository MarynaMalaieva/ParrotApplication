package com.example.parrotapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parrotapplication.model.ParrotsViewModel
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme
import com.example.parrotapplication.ui.theme.feed.Feed

class MainActivity : ComponentActivity() {
    fun showDialer() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:32466656545")
        startActivity(intent)
    }
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
                    MainScreen(ViewModel, this.showDialer())
                }
            }
        }
    }

}

@Composable
fun MainScreen(viewModel: ParrotsViewModel, callDialer: Unit?){
    val state by viewModel.parrots.collectAsState()
    Feed(parrots = state, onSelected = {})
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ParrotApplicationTheme {
        MainScreen(ParrotsViewModel(), null)
    }
}