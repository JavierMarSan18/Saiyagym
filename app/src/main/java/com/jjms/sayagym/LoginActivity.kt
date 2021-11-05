package com.jjms.sayagym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var txtEmail : EditText
    private lateinit var txtPassword : EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtEmail = findViewById(R.id.txtEmailLogin)
        txtPassword = findViewById(R.id.txtPasswordLogin)

        auth = FirebaseAuth.getInstance()

    }

    fun onClickLogin(view: android.view.View) {
        loginUser()
    }

    private fun loginUser(){
        val email = txtEmail.text.toString()
        val password = txtPassword.text.toString()

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){
                    task ->
                    if(task.isSuccessful){
                        action()
                    }else{
                        Toast.makeText(this, "Error en la autenticación", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun action(){
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun onClickNewRegister(view: android.view.View) {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}