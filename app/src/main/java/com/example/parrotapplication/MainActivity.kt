package com.example.parrotapplication

import android.content.Intent
import android.net.Uri
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

        val ViewModel: ParrotsViewModel by viewModels()
        setContent {
            ParrotApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(ViewModel
//                        ::showDialer
                    )
                }
            }
        }
    }

//    private fun showDialer() {
//        val intent = Intent(Intent.ACTION_DIAL)
//        intent.data = Uri.parse("tel:32466656545")
//        startActivity(intent)
//    }
}

@Composable
fun MainScreen(viewModel: ParrotsViewModel
//               , showDial: () -> Unit
){
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
        ParrotProfile(parrot = viewModel.getById(id),
//            showDial = showDial
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
    fun empty() {}
    ParrotApplicationTheme {
        MainScreen(ParrotsViewModel())
    }
}