package com.example.adminwaves_of_food_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminwaves_of_food_app.databinding.ActivityAddItemBinding
import com.example.adminwaves_of_food_app.databinding.ActivitySignUpBinding

class AddItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.selectImage.setOnClickListener{
              pickImage.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
       }

        binding.backButton.setOnClickListener{
            finish()
        }

    }
    val pickImage = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){uri ->
        if(uri != null){
            binding.selectedImage.setImageURI(uri)
        }
    }
}