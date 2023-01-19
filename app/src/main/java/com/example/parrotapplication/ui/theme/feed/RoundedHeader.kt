package com.example.parrotapplication.ui.theme.feed

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme

@Composable
fun RoundedHeader(title: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        tonalElevation = 0.dp,
        shape = RoundedCornerShape(
            topStartPercent = 50,
            topEndPercent = 50,
            bottomEndPercent = 0,
            bottomStartPercent = 0
        )

    )
    {
        val paddingValues = 16.dp
        Text(
            text = title,
            modifier = Modifier.padding(start = paddingValues, top = paddingValues, end = paddingValues),
            style = MaterialTheme.typography.headlineMedium
        )

    }
}

@Preview
@Composable
fun RoundedHeaderPreview() {
    ParrotApplicationTheme() {
        RoundedHeader(title = "Header")
        
    }
}