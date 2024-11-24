package com.example.adminwaves_of_food_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminwaves_of_food_app.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.dontHaveAccountButton.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}