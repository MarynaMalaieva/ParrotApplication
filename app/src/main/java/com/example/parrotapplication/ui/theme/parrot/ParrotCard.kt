package com.example.parrotapplication.ui.theme.parrot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
    val padding = 10.dp
    Column(
        modifier = Modifier
            .clickable (onClick = onClick)
            .padding(
                top = padding / 2,
                start = padding,
                end = padding,
                bottom = padding / 2
            )
            .fillMaxWidth()
            .border(
                border = ButtonDefaults.outlinedButtonBorder,
                shape = RoundedCornerShape(10.dp)
            )
            .background(color = Color(red = 135, green = 148, blue = 228, alpha = 226))
    ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(10f)
                        .height(80.dp)

                ) {
            Image(
                painter = painterResource(id = parrot.avatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(70.dp)
                    .padding(3.dp)
                    .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
            )
            Spacer(Modifier.size(padding))
            Column {
                Text(
                    text = parrot.name,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = parrot.breed,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Light,
                        color = Color(red = 61, green = 61, blue = 61, alpha = 255)
                    ),

                )
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