package com.example.parrotapplication.ui.profile

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun DialButton() {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:328695741"))
                context.startActivity(intent)
            }
        ) {
            Text(text = "Contact for buy")
        }
    }
}
