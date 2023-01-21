package com.example.parrotapplication.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parrotapplication.R
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme

@Composable
fun RoundedHeader(avatar: Int) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        tonalElevation = 0.dp,
        shape = RoundedCornerShape(
            topStartPercent = 0,
            topEndPercent = 0,
            bottomEndPercent = 13,
            bottomStartPercent = 13
        )

    )
    {
//        val paddingValues = 16.dp
        Image(
            painter = painterResource(id = avatar),
            contentDescription = "Avatar",
//            modifier = Modifier
//                .size(50.dp)
//                .padding(
//                    top = 2.dp,
//                    start = 5.dp,
//                    end = 0.dp,
//                    bottom = 2.dp
//                )
//                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter
        )

    }
}

@Preview
@Composable
fun RoundedHeaderPreview() {
    ParrotApplicationTheme() {
        RoundedHeader(avatar = R.drawable.budgerigar_1)

    }
}