package com.example.adminwaves_of_food_app

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminwaves_of_food_app.adapter.OutForDeliveryAdapter
import com.example.adminwaves_of_food_app.databinding.ActivityOutForDeliveryBinding

class OutForDeliveryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOutForDeliveryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOutForDeliveryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
        }
        val CustomerName = listOf("Vaibhaw","Soni","Mahesh","Suresh")
        val MoneyStatus = listOf("received","notReceived","delivered","notReceived")
        val adapter = OutForDeliveryAdapter(ArrayList(CustomerName),ArrayList(MoneyStatus))
        binding.outForDeliveryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.outForDeliveryRecyclerView.adapter = adapter

    }
}