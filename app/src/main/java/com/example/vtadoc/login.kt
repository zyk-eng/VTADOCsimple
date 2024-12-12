package com.example.vtadoc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val guest: Button = findViewById (R.id.guest)
        val student:Button = findViewById (R.id.student)
        val staff:Button = findViewById (R.id.staff)

        guest.setOnClickListener {
            val intent = Intent(this,guestacc::class.java)
            startActivity(intent)
        }
        student.setOnClickListener {
            val intent = Intent(this,stlogin::class.java)
            startActivity(intent)
        }
        staff.setOnClickListener {
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