package com.example.parrotapplication.ui.profile

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.parrotapplication.R
import com.example.parrotapplication.model.Parrot
import com.example.parrotapplication.ui.theme.ParrotApplicationTheme


@Composable
fun ParrotProfile(
    parrot: Parrot,
    modifier: Modifier = Modifier,
//    showDial: () -> Unit,
) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn() {
            item { RoundedHeader(avatar = parrot.avatar) }
            item { Text(
                text = parrot.name,
                style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Medium),
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            ) }
            item { Field("Breed", parrot.breed) }
            item { Field("Age(month)", parrot.age.toString()) }
            item { Field("Sex", parrot.sex) }
            item {
               Column(
                   modifier = Modifier
                   .fillMaxSize(),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Bottom,) {
                   openDialer()
//                   Row(
//                       modifier = Modifier
//                           .fillMaxSize(),
//                       horizontalArrangement = Arrangement.Center,
//                       verticalAlignment = Alignment.Bottom
//                   ) {
//                       Button(
//                           onClick = { showDialer() }
//                       ) {
//                           Text(text = "Contact for buy")
//                       }
//                   }
               }
            }

        }

    }
}



//@Composable
// fun showDialer() {
//    val intent = Intent(Intent.ACTION_DIAL)
//    intent.data = Uri.parse("tel:32466656545")
//    val ctx = LocalContext.current
//    startActivity(ctx,intent, null)
//}
@Composable
fun openDialer() {

    // on below line we are creating
    // a variable for a context
    val ctx = LocalContext.current

    // on below line we are creating a column
    Column(
        // on below line we are specifying modifier
        // and setting max height and max width
        // for our column
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            // on below line we are
            // adding padding for our column
            .padding(5.dp),
        // on below line we are specifying horizontal
        // and vertical alignment for our column
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // on below line adding a button to open URL
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    val u = Uri.parse("tel:328695741")

                    // Create the intent and set the data for the
                    // intent as the phone number.
                    val i = Intent(Intent.ACTION_DIAL, u)
                    try {
                        // Launch the Phone app's dialer with a phone
                        // number to dial a call.
                        ctx.startActivity(i)
                    } catch (s: SecurityException) {

                        // show() method display the toast with
                        // exception message.
//                Toast.makeText(ctx, "An error occurred", Toast.LENGTH_LONG)
//                    .show()
                    }
                }
            ) {
                Text(text = "Contact for buy")
            }
        }
//        Button(onClick = {
//            // on below line we are opening the dialer of our
//            // phone and passing phone number.
//            // Use format with "tel:" and phoneNumber created is
//            // stored in u.
//            val u = Uri.parse("tel:328695741")
//
//            // Create the intent and set the data for the
//            // intent as the phone number.
//            val i = Intent(Intent.ACTION_DIAL, u)
//            try {
//                // Launch the Phone app's dialer with a phone
//                // number to dial a call.
//                ctx.startActivity(i)
//            } catch (s: SecurityException) {
//
//                // show() method display the toast with
//                // exception message.
////                Toast.makeText(ctx, "An error occurred", Toast.LENGTH_LONG)
////                    .show()
//            }
//
//
//        }) {
//            // on below line creating a text for our button.
//            Text(
//                // on below line adding a text ,
//                // padding, color and font size.
//                text = "Dial",
//                modifier = Modifier.padding(10.dp),
//                color = Color.White,
//                fontSize = 15.sp
//            )
//        }
    }
}

@Preview
@Composable
fun ParrotProfilePreview() {
    val parrot = Parrot(
        id = "1",
        name = "Ozzy",
        age = 12,
        sex = "male",
        breed = "Scarlet Macaw",
        avatar = R.drawable.scarletmacaw_1
    )
    ParrotApplicationTheme() {
//        ParrotProfile(parrot = parrot)

    }
}