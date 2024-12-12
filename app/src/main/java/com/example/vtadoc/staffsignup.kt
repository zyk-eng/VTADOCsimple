package com.example.vtadoc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class staffsignup : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_staffsignup)

        val stafid: EditText=findViewById(R.id.stafid)
        val sfname:EditText=findViewById(R.id.sfname)
        val sfemail:EditText=findViewById(R.id.sfemail)
        val sfpassword:EditText=findViewById(R.id.sfpassword)
        val sfconpassword:EditText=findViewById(R.id.sfconpassword)
        val stlogin:Button=findViewById(R.id.stlogin)
        val stafSignUp2:Button=findViewById(R.id.stSignUp3)



        stafSignUp2.setOnClickListener {
            // Get user inputs
            val staffId = stafid.text.toString()
            val staffName = sfname.text.toString()
            val email = sfemail.text.toString()
            val password = sfpassword.text.toString()
            val confirmPassword = sfconpassword.text.toString()

            if (staffId.isEmpty() || staffName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show()
            } else {
                // Handle signup logic (e.g., save to database, send to server)
                Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
            }
        }

        stlogin.setOnClickListener {
            val intent = Intent(this,staflogin::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}