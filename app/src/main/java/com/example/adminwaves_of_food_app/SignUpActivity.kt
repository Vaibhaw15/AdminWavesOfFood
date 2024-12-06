package com.example.adminwaves_of_food_app

import android.accounts.Account
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminwaves_of_food_app.databinding.ActivitySignUpBinding
import com.example.adminwaves_of_food_app.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class SignUpActivity : AppCompatActivity() {

    private lateinit var userName: String
    private lateinit var nameOfResturant: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var auth: FirebaseAuth
    private lateinit var dataBase: DatabaseReference

    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initializing firebase
        auth = Firebase.auth
        dataBase = Firebase.database.reference


        binding.createUserButton.setOnClickListener {
            // get text from edit text
            userName = binding.name.toString().trim()
            nameOfResturant = binding.resturantName.text.toString().trim()
            email = binding.emailOrPhone.text.toString().trim()
            password = binding.password.text.toString().trim()

            if(userName.isBlank() || nameOfResturant.isBlank() || email.isBlank() || password.isBlank()){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            }else{
                createAccount(email,password)
            }

        }
        binding.alreadyHaveAccount.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        val locationList = arrayOf("jaipur", "odisha", "sikar", "jharkhand")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)


    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                        saveUserData()
                        val intent = Intent(this,LogInActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, "Account creation failed", Toast.LENGTH_SHORT).show()
                        Log.d("Account","createAccount:Failure",task.exception)
                    }
        }
    }

    //save data in to Database
    private fun saveUserData() {
        userName = binding.name.text.toString().trim()
        nameOfResturant = binding.resturantName.text.toString().trim()
        email = binding.emailOrPhone.text.toString().trim()
        password = binding.password.text.toString().trim()

        val user = UserModel(userName,nameOfResturant,email,password)
        val userId:String = FirebaseAuth.getInstance().currentUser!!.uid
        //save user data in firebase database
        dataBase.child("users").child(userId).setValue(user)
    }
}