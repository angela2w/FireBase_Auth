package com.example.firebaseauthication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var EdtEmail: EditText
    private lateinit var EdtPass: EditText
    lateinit var EdtConPas: EditText
    private lateinit var BtnSignup: Button
    lateinit var TvDirectLogin: TextView
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EdtEmail=findViewById(R.id.edtEmail)
        EdtPass=findViewById(R.id.edtpassword)
        EdtConPas=findViewById(R.id.edtconfirmpassword)
        BtnSignup=findViewById(R.id.btnsigned)
        TvDirectLogin=findViewById(R.id.Tvredirectlogin)
        auth= Firebase.auth

        BtnSignup.setOnClickListener {
            SignUpUser()
        }
        TvDirectLogin.setOnClickListener {
            val intent=Intent(this,Registration::class.java)
            startActivity(intent)
        }
    }
    private fun SignUpUser(){
        val email=EdtEmail.text.toString()
        val pass=EdtPass.text.toString()
        val confirmpass=EdtConPas.text.toString()
        if (email.isBlank() || pass.isBlank() || confirmpass.isBlank()){
            Toast.makeText(this,"Please Email and password cant be blank", Toast.LENGTH_LONG).show()
            return
        }  else if (pass != confirmpass){
            Toast.makeText(this,"Password do not match", Toast.LENGTH_LONG).show()
            return

        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Successfuly Logged In", Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Log in failed", Toast.LENGTH_LONG).show()
            }

        }
    }
}
