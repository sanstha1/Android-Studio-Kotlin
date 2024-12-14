package com.example.basics

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display)
        val fullName = intent.getStringExtra("fullName")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val country = intent.getStringExtra("country")
        val city = intent.getStringExtra("city")

        findViewById<TextView>(R.id.Welcome).text = "Welcome, $fullName"
        findViewById<TextView>(R.id.Email).text = "Email: $email"
        findViewById<TextView>(R.id.Gender).text = "Gender: $gender"
        findViewById<TextView>(R.id.Country).text = "Country: $country"
        findViewById<TextView>(R.id.City).text = "City: $city"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}