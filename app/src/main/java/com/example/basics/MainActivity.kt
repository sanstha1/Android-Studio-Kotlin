package com.example.basics

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var fullNameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var genderRadioGroup: RadioGroup
    lateinit var spinner: Spinner
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var checkBox: CheckBox
    lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image)
        fullNameEditText = findViewById(R.id.fullname)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        genderRadioGroup = findViewById(R.id.genderradiogroup)
        spinner = findViewById(R.id.countryspinner)
        autoCompleteTextView = findViewById(R.id.city)
        checkBox = findViewById(R.id.checkbox)
        button = findViewById(R.id.button)

        val countries = arrayOf("Nepal","China","Korea","Japan")
        val countryAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,countries)
        spinner.adapter = countryAdapter

        val cities = arrayOf("Kathmandu", "Beijing", "Seoul", "Tokyo")
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
        autoCompleteTextView.setAdapter(cityAdapter)

        button.setOnClickListener {

            val fullName = fullNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString()


            val selectedGenderId = genderRadioGroup.checkedRadioButtonId
            val gender = when (selectedGenderId) {
                R.id.maleradiobutton -> "Male"
                R.id.femaleradiobutton -> "Female"
                else -> {
                    Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            val country = spinner.selectedItem.toString()
            val city = autoCompleteTextView.text.toString()


            if (!checkBox.isChecked) {
                Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("fullName", fullName)
            intent.putExtra("email", email)
            intent.putExtra("gender", gender)
            intent.putExtra("country", country)
            intent.putExtra("city", city)


            startActivity(intent)


            Toast.makeText(this, "Form submitted successfully!", Toast.LENGTH_SHORT).show()
        }





            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}