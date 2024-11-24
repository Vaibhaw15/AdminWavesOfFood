package com.example.adminwaves_of_food_app

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminwaves_of_food_app.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val locationList = arrayOf("jaipur","odisha","sikar","jharkhand")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)

        binding.createButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.alreadyHaveAccount.setOnClickListener{
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }

    }
}