package com.example.vtadoc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class stregister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_stregister)

        val mis: EditText =findViewById(R.id.mis)
        val stname: EditText =findViewById(R.id.stname)
        val stemail: EditText =findViewById(R.id.stemail)
        val stpassword: EditText =findViewById(R.id.stpassword)
        val stconpassword: EditText =findViewById(R.id.stconpassword)
        val stSignUp2: Button =findViewById(R.id.stSignUp2)
        val sflogin: Button =findViewById(R.id.sflogin)



        stSignUp2.setOnClickListener {
            // Get user inputs
            val staffId = mis.text.toString()
            val staffName = stname.text.toString()
            val email = stemail.text.toString()
            val password = stpassword.text.toString()
            val confirmPassword = stconpassword.text.toString()

            if (staffId.isEmpty() || staffName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show()
            } else {
                // Handle signup logic (e.g., save to database, send to server)
                Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
            }
        }

        sflogin.setOnClickListener {
            val intent = Intent(this,stlogin::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}