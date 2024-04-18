package com.example.poe_part_2_attempt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.poe_part_2_attempt.databinding.ActivityRegistrationPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegistrationPage : AppCompatActivity() {
    private lateinit var binding : ActivityRegistrationPageBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

    }
    private fun register(){

        var email = binding.emailET.text.toString()
        var password = binding.passwordET.text.toString()

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){

            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                finish()
                val intent = Intent(this,ProfilePage::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
            }


        }
    }
}