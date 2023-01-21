package com.example.parrotapplication.ui.theme.parrot

import android.graphics.Paint.Style
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
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
//    style: Style
) {
    val padding = 10.dp
    Column(
        modifier
            .clickable(onClick = onClick)
            .padding(
                top = padding,
                start = padding / 2,
                end = padding /2,
                bottom = padding / 2
            )
            .fillMaxWidth()
            .background(
                color = Color(red = 194, green = 194, blue = 194, alpha = 65),
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                border = ButtonDefaults.outlinedButtonBorder,
                shape = RoundedCornerShape(10.dp)
            ),




    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth(10f)
                .height(80.dp)

        ) {
            Image(
                painter = painterResource(id = parrot.avatar),
                contentDescription = "Avatar",
                modifier
                    .size(70.dp)
                    .padding(
                        top = 2.dp,
                        start = 5.dp,
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