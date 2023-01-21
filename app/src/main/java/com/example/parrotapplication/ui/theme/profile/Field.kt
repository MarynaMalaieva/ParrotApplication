package com.example.parrotapplication.ui.theme.profile

import android.icu.lang.UCharacter.LineBreak
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parrotapplication.R
import com.example.parrotapplication.model.Parrot
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme
import com.example.parrotapplication.ui.theme.parrot.ParrotCard

@Composable
fun Field(
    fieldName: String,
    fieldValue: String,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        val padding = 20.dp
        Column(
            modifier
                .fillMaxWidth()
                .padding(
                    top = padding / 2,
                    start = padding,
                    end = padding,
                    bottom = padding / 2
                )

        ) {
            Text(
                text = fieldName,
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light)
            )
            Text(
                text = fieldValue,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
            )
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 1.dp,
                        end = 5.dp,
                        top = 1.dp,
                        bottom = 3.dp
                    )
            )

        }
    }
}


@Preview
@Composable
fun FieldPreview() {
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
            Field("Age(month)", parrot.age.toString())

        }
    }
}