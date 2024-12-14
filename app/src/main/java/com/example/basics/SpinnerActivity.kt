package com.example.basics

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpinnerActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener {
    lateinit var spinner :Spinner
    lateinit var textView: TextView
    lateinit var autoCompleteTextView: AutoCompleteTextView
    val countries = arrayOf("Nepal","India","Japan","Korea")
    val cities = arrayOf("Kathmandu","Bhaktapur","Lalitpur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        spinner = findViewById(R.id.Item)
        textView = findViewById(R.id.textView9)
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)

        val autoAdapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_dropdown_item_1line,
            cities
        )
        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold = 2

        val adapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item,
            countries
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view : View?, position: Int, id: Long) {
        if(parent != null){
            textView.text = parent.getItemAtPosition(position)
                .toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}