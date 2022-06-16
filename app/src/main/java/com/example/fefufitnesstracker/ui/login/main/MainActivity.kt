package com.example.fefufitnesstracker.ui.login.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fefufitnesstracker.R
import com.example.fefufitnesstracker.retrofit.AuthHolder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val authHolder = AuthHolder(this)

        if (authHolder.checkToken()) {
            startActivity(Intent(this, MainAppActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        }
    }
}