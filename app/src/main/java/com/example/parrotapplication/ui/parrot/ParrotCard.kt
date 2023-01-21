package com.example.parrotapplication.ui.parrot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parrotapplication.R
import com.example.parrotapplication.model.Parrot
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme

@Composable
fun ParrotCard(
    parrot: Parrot,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val padding = 10.dp
    val color = Color(red = 241, green = 239, blue = 239, alpha = 255)
    Column(
        modifier
            .clickable(onClick = onClick)
            .padding(
                top = padding,
                start = padding / 2,
                end = padding / 2,
                bottom = padding / 10
            )
            .fillMaxWidth()
            .background(
                color,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color,
                shape = RoundedCornerShape(10.dp)
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth(10f)
                .height(100.dp)
        ) {
            Image(
                painter = painterResource(id = parrot.avatar),
                contentDescription = "Avatar",
                modifier
                    .size(90.dp)
                    .padding(
                        top = 2.dp,
                        start = 6.dp,
                        end = 0.dp,
                        bottom = 2.dp
                    )
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.size(padding))
            Column {
                Text(
                    text = parrot.name,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = parrot.breed,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Light,
                        color = Color.DarkGray
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
fun ParrotCardPreview() {
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
