package com.example.parrotapplication.ui.theme.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme

@Composable
fun ProfileHeader() {
 Surface(
     color = MaterialTheme.colorScheme.onSurface,
     contentColor = MaterialTheme.colorScheme.surface
 ) {

     Column {
//         RoundedHeader(title = "Our pets")
         Spacer(modifier = Modifier
             .size(24.dp)
         )
         Text(
             text = "Parrot store",
             style = MaterialTheme.typography.displaySmall,
             modifier = Modifier
                 .padding(start = 16.dp)
                 )


//         Text(
//             text ="Our pets",
//             style = MaterialTheme.typography.bodySmall,
//             modifier = Modifier.padding(start = 16.dp)
//         )
         Spacer(modifier = Modifier.size(16.dp))

     }
     
 }
}

@Preview
@Composable
fun FeedHeaderPreview() {
    ParrotApplicationTheme {
        ProfileHeader()
    }
}