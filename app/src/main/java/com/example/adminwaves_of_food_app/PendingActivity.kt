package com.example.adminwaves_of_food_app

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminwaves_of_food_app.adapter.PendingOrderAdapter
import com.example.adminwaves_of_food_app.databinding.ActivityPendingBinding

class PendingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPendingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPendingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val customerName = listOf("Vaibhaw","Suresh","Mahesh","Vaibhaw","Suresh","Mahesh","Vaibhaw","Suresh","Mahesh")
        val quantity = listOf("1","2","3","4","5","6","7","8","9")
       val adapter = PendingOrderAdapter(ArrayList(customerName), ArrayList(quantity))
        binding.pendingOrder.layoutManager = LinearLayoutManager(this)
        binding.pendingOrder.adapter = adapter
        binding.backButton.setOnClickListener{
            finish()
        }
    }
}