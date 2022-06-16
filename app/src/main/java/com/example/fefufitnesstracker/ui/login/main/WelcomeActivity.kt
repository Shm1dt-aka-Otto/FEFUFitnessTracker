package com.example.fefufitnesstracker.ui.login.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.fefufitnesstracker.R
import com.example.fefufitnesstracker.ui.login.signin.SignInActivity
import com.example.fefufitnesstracker.ui.login.signup.SignUpActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        findViewById<Button>(R.id.btnRegistration).setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        findViewById<TextView>(R.id.loginView).setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }
}