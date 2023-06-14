package com.example.firebaseauthication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class Registration : AppCompatActivity() {
    lateinit var text_gotologin: TextView
    lateinit var EdtLoginEmail: EditText
    lateinit var EdtTextPassword: EditText
    lateinit var EditConfirmPassword: EditText
    lateinit var EdiButton : Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)
        text_gotologin = findViewById(R.id.TvRegistration)
        EdtLoginEmail = findViewById(R.id.EditLoginEmail)
        EdtTextPassword = findViewById(R.id.EditTextPassword)
        EditConfirmPassword = findViewById(R.id.EdtConfirmPassword)
        EdiButton = findViewById(R.id.EdtConfirmPassword)

        auth = FirebaseAuth.getInstance()







    }    }

