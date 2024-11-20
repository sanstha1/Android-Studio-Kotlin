package com.example.basics

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {
    lateinit var anime :RadioButton
    lateinit var anime2 :RadioButton
    lateinit var manga :RadioButton
    lateinit var image :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)

        anime = findViewById(R.id.radioAnime)
        anime2 = findViewById(R.id.radioAnime2)
        manga = findViewById(R.id.radioManga)
        image = findViewById(R.id.imageView)

        anime.setOnClickListener {
            image.setImageResource(R.drawable.anime)
        }
        anime2.setOnClickListener {
            image.setImageResource(R.drawable.anim)
        }
        manga.setOnClickListener {
            image.setImageResource(R.drawable.manga)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}