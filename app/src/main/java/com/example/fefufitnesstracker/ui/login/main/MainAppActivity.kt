package com.example.fefufitnesstracker.ui.login.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.fefufitnesstracker.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainapp)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment).navController
        bottomNavView.setupWithNavController(navController)
    }
}