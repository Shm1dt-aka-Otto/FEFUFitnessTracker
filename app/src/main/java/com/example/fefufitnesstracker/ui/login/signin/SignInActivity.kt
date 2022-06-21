package com.example.fefufitnesstracker.ui.login.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.viewModels
import com.example.fefufitnesstracker.CustomViewModelFactory
import com.example.fefufitnesstracker.R
import com.example.fefufitnesstracker.retrofit.AuthHolder
import com.example.fefufitnesstracker.ui.login.main.MainAppActivity
import com.example.fefufitnesstracker.ui.login.main.WelcomeActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignInActivity : AppCompatActivity() {

    private val viewModel by viewModels<SignInViewModel> {
        CustomViewModelFactory { SignInViewModel(AuthHolder(applicationContext)) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        }

        viewModel.showLoginError.observe(this) {
            if (it) {
                findViewById<TextInputLayout>(R.id.loginInput).error = "Введите логин"
            } else {
                findViewById<TextInputLayout>(R.id.loginInput).error = null
            }
        }
        viewModel.showPasswordError.observe(this) {
            if (it) {
                findViewById<TextInputLayout>(R.id.passwordInput).error = "Введите пароль"
            } else {
                findViewById<TextInputLayout>(R.id.passwordInput).error = null
            }
        }

            findViewById<Button>(R.id.btnLogin).setOnClickListener {
            viewModel.onLoginClicked(
                findViewById<TextInputEditText>(R.id.login).text.toString(),
                findViewById<TextInputEditText>(R.id.password).text.toString()
            )
        }

        viewModel.result.observe(this) {
            if (it == "Успех") {
                startActivity(Intent(this, MainAppActivity::class.java))
                finish()
            } else if (it != "") {
                Toast.makeText(
                    this,
                    it,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}