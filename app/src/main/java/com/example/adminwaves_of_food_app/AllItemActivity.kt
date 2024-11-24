package com.example.adminwaves_of_food_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminwaves_of_food_app.adapter.AddItemAdapter
import com.example.adminwaves_of_food_app.databinding.ActivityAllItemBinding
import java.util.ArrayList

class AllItemActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAllItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAllItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val menuFoodName = listOf("Burger","Pizza","Sandwitch","Momo")
        val menuFoodPrice = listOf("$5","$10","$15","$20")
        val menuFoodImage = listOf(R.drawable.pizza,R.drawable.pizza,R.drawable.pizza,R.drawable.pizza)
        val adapter = AddItemAdapter(ArrayList(menuFoodName),ArrayList(menuFoodPrice),ArrayList(menuFoodImage))
        binding.MenuRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.MenuRecyclerView.adapter = adapter
        binding.backButton.setOnClickListener {
            finish()
        }

    }
}