package com.example.vtadoc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class stpasswordreset : AppCompatActivity() {
    private fun resetPassword(email: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_stpasswordreset)
        val emailEditText :EditText = findViewById(R.id.emailEditText)
         val resetPasswordButton : Button = findViewById(R.id.resetPasswordButton)
        val messageTextView : TextView = findViewById(R.id.messageTextView)




        // Set up reset password button click listener
        resetPasswordButton.setOnClickListener {
            // Get email from the input field
            val email = emailEditText.text.toString()

            // Basic email validation
            if (email.isEmpty()) {
                messageTextView.text = "Please enter your email address."
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                messageTextView.text = "Please enter a valid email address."
            } else {
                // Simulate a password reset process
                resetPassword(email)
            }
            messageTextView.text = "A password reset link has been sent to your email."
            Toast.makeText(this, "Password reset email sent to $email", Toast.LENGTH_SHORT).show()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }}}