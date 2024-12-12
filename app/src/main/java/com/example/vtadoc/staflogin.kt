package com.example.vtadoc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class staflogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_staflogin)
        // Initialize UI elements
        val inputstemail: EditText = findViewById(R.id.inputstemail)
        val stpasswordin: EditText = findViewById(R.id.stpasswordin)
        val stlogin: Button = findViewById(R.id.stlogin)
        val stSignUp:Button = findViewById(R.id.stafSignUp2)
        val sfreset: TextView =findViewById(R.id.sfreset1)

        // Hardcoded credentials for testing
        val correctUsername = "admins"
        val correctPassword = "12345"

        stlogin.setOnClickListener {
            val username = inputstemail.text.toString().trim()
            val password = stpasswordin.text.toString().trim()

            if (username == correctUsername && password == correctPassword) {
                // Navigate to the next activity
                val intent = Intent(this, staffdash::class.java)
                startActivity(intent)
                finish() // Optional: Close the login screen
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()            }
        }

        stSignUp.setOnClickListener {
            val intent =Intent(this,staffsignup::class.java)
            startActivity(intent)
        }

        sfreset.setOnClickListener {
            val intent = Intent(this,sfpasswordreset::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}