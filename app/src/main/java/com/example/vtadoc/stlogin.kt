package com.example.vtadoc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class stlogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stlogin)

        // Initialize UI elements
        val inputstemail: EditText = findViewById(R.id.inputstemail)
        val stpasswordin: EditText = findViewById(R.id.stpasswordin)
        val stlogin: Button = findViewById(R.id.stlogin)
        val stSignUp2 :Button =findViewById(R.id.stSignUp2)
        val streset:TextView =findViewById(R.id.streset1)

        // Hardcoded credentials for testing
        val correctUsername = "student"
        val correctPassword = "12345"

        stlogin.setOnClickListener {
            val username = inputstemail.text.toString().trim()
            val password = stpasswordin.text.toString().trim()

            if (username == correctUsername && password == correctPassword) {
                // Navigate to the next activity
                val intent = Intent(this, stdash::class.java)
                startActivity(intent)
                finish() // Optional: Close the login screen
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()            }
        }

        stSignUp2.setOnClickListener {
            val intent = Intent(this,stregister::class.java)
            startActivity(intent)
        }

        streset.setOnClickListener {
            val intent = Intent(this,stpasswordreset::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}