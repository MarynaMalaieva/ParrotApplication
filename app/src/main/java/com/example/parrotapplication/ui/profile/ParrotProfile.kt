package com.example.parrotapplication.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.parrotapplication.R
import com.example.parrotapplication.model.Parrot
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme


@Composable
fun ParrotProfile(
    parrot: Parrot,
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn() {
            item { RoundedHeader(avatar = parrot.avatar) }
            item {
                Text(
                    text = parrot.name,
                    style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Medium),
                    modifier = modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            item { Field("Breed", parrot.breed) }
            item { Field("Age(month)", parrot.age.toString()) }
            item { Field("Sex", parrot.sex) }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    DialButton()
                }
            }
        }
    }
}

@Preview
@Composable
fun ParrotProfilePreview() {
    val parrot = Parrot(
        id = "1",
        name = "Ozzy",
        age = 12,
        sex = "male",
        breed = "Scarlet Macaw",
        avatar = R.drawable.scarletmacaw_1
    )
    ParrotApplicationTheme() {
        ParrotProfile(parrot = parrot)
    }
}
