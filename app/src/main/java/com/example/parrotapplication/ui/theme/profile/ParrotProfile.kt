package com.example.parrotapplication.ui.theme.profile

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.parrotapplication.R
import com.example.parrotapplication.model.Parrot
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme


@Composable
fun ParrotProfile(
    parrot: Parrot,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn() {
            item { RoundedHeader(avatar = parrot.avatar) }
            item { Text(
                text = parrot.name,
                style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Medium),
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            ) }
            item { Field("Breed", parrot.breed) }
            item { Field("Age(month)", parrot.age.toString()) }
            item { Field("Sex", parrot.sex) }
            item { Button(onClick = {
//                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "Your Phone_number"))
//                startActivity(intent)
            }) {
                Text(text = "Cell")
                
            } }
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