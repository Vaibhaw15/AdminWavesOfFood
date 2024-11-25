package com.example.adminwaves_of_food_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminwaves_of_food_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addMenu.setOnClickListener{
            val intent = Intent(this, AddItemActivity::class.java)
            startActivity(intent)
        }
        binding.addNewUser.setOnClickListener{
            val intent = Intent(this, CreateNewActivity::class.java)
            startActivity(intent)
        }
        binding.allItem.setOnClickListener{
            val intent = Intent(this, AllItemActivity::class.java)
            startActivity(intent)

        }
        binding.outForDelivery.setOnClickListener{
            val intent = Intent(this, OutForDeliveryActivity::class.java)
            startActivity(intent)
        }

    }
}