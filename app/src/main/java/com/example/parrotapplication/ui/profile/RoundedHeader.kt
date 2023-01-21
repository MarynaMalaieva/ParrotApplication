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
        shape = RoundedCornerShape(
            bottomEndPercent = 13,
            bottomStartPercent = 13
        )
    ) {
        Image(
            alignment = Alignment.TopCenter,
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            painter = painterResource(id = avatar),
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
