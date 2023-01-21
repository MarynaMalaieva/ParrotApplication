//package com.example.parrotapplication.ui.theme.profile
//
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.view.View
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.gfgreviewinjava.R
//
//class ButtonActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Binding MainActivity.java with
//        // activity_main.xml file
//        setContentView(R.layout.activity_main)
//    }
//
//    // This function is called when button is clicked.
//    fun Call(v: View?) {
//        // Find the EditText by its unique ID
//        val e = findViewById<View>(R.id.editText) as EditText
//
//        // show() method display the toast with message
//        // "clicked"
//        Toast.makeText(this, "clicked", Toast.LENGTH_LONG)
//            .show()
//
//        // Use format with "tel:" and phoneNumber created is
//        // stored in u.
//        val u = Uri.parse("tel:" + e.text.toString())
//
//        // Create the intent and set the data for the
//        // intent as the phone number.
//        val i = Intent(Intent.ACTION_DIAL, u)
//        try {
//            // Launch the Phone app's dialer with a phone
//            // number to dial a call.
//            startActivity(i)
//        } catch (s: SecurityException) {
//            // show() method display the toast with
//            // exception message.
//            Toast.makeText(this, "An error occurred", Toast.LENGTH_LONG)
//                .show()
//        }
//    }
//}