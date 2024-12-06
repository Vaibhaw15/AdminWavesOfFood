package com.example.adminwaves_of_food_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminwaves_of_food_app.databinding.ActivityLogInBinding
import com.example.adminwaves_of_food_app.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class LogInActivity : AppCompatActivity() {

    private  var userName: String ?= null
    private var nameOfResturant: String ?= null
    private lateinit var email:String
    private lateinit var password:String
    private lateinit var auth:FirebaseAuth
    private lateinit var database:DatabaseReference

    private lateinit var binding : ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database = Firebase.database.reference

        binding.loginButton.setOnClickListener{
            //get text from edit text
            email = binding.loginEmail.text.toString()
            password = binding.loginPassword.text.toString()

            if(email.isBlank() || password.isBlank()){
                Toast.makeText(this, "Please Fill All Details", Toast.LENGTH_SHORT).show()
            }else{
                createUserAccount(email,password)
            }
        }
        binding.dontHaveAccountButton.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

    }

    private fun createUserAccount(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user: FirebaseUser? = auth.currentUser
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                updateUi(user)
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this,
                            "Create User and Login Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        val user: FirebaseUser? = auth.currentUser
                        saveUserData()
                        updateUi(user)
                    } else {
                        Toast.makeText(this, "Account creation failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun saveUserData(){
        email = binding.loginEmail.text.toString()
        password = binding.loginPassword.text.toString()
        val user = UserModel(userName,nameOfResturant,email,password)
        val userId:String? = FirebaseAuth.getInstance().currentUser?.uid
        //save user data in firebase database
       userId?.let {
           database.child("users").child(it).setValue(user)
       }

    }

    private fun updateUi(user : FirebaseUser?){
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}