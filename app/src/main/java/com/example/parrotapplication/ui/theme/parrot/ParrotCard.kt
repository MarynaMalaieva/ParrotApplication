package com.example.parrotapplication.ui.theme.parrot

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parrotapplication.R
import com.example.parrotapplication.model.Parrot
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme

@Composable
fun ParrotCard (
    parrot: Parrot,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val padding = 16.dp
    Column() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = parrot.avatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(50.dp)
                    .padding(3.dp)
                    .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
            )
            Spacer(Modifier.size(padding))
            Column {
                Text(
                    text = parrot.name,
                    style = MaterialTheme.typography.body1.copy()
                )
                Text(text = parrot.breed)
            }

        }
    }
}

@Preview
@Composable
fun ParrotCardPreview(){
    val parrot = Parrot(
        id = "1",
        name = "Ozzy",
        age = 12,
        sex = "male",
        breed = "Scarlet Macaw",
        avatar = R.drawable.scarletmacaw_1
            )

    ParrotApplicationTheme {
        Surface {
            ParrotCard(parrot, {})

        }
    }
}