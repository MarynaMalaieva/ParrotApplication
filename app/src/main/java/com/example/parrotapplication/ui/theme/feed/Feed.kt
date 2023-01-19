package com.example.parrotapplication.ui.theme.feed

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parrotapplication.R
import com.example.parrotapplication.model.Parrot
import com.example.parrotapplication.ui.theme.parrot.ParrotCard
import androidx.compose.foundation.lazy.items
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme

@Composable
fun Feed(
    parrots: List<Parrot>,
    onSelected: (Parrot) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize()) {
        val listState = rememberLazyListState()
        LazyColumn() {
            item { FeedHeader() }
            items(parrots) { parrot ->
                ParrotCard(parrot = parrot, onClick = { onSelected(parrot) })
            }
        }

    }
}

@Preview
@Composable
fun FeedPreview() {
    val parrot = Parrot(
        id = "1",
        name = "Ozzy",
        age = 12,
        sex = "male",
        breed = "Scarlet Macaw",
        avatar = R.drawable.scarletmacaw_1
    )
    ParrotApplicationTheme() {
        Feed(parrots = listOf(parrot), onSelected ={} )

    }
}