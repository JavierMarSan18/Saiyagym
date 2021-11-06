package com.jjms.sayagym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    private lateinit var txtName : EditText
    private lateinit var txtAge : EditText
    private lateinit var txtEmail : EditText
    private lateinit var txtPassword : EditText
    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var dbReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        txtName = findViewById(R.id.txtName)
        txtAge = findViewById(R.id.txtAge)
        txtEmail = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtPassword)

        database = FirebaseDatabase.getInstance()
        dbReference = database.reference.child("User")

        auth = FirebaseAuth.getInstance()
    }

    fun onClickRegister(view: android.view.View) {
        createNewAccount()
    }

    private fun createNewAccount(){
        val name = txtName.text.toString()
        val age = txtAge.text.toString()
        val email = txtEmail.text.toString()
        val password = txtPassword.text.toString()

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(age) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){
                    task ->
                    if(task.isSuccessful){
                        val user : FirebaseUser? = auth.currentUser
                        verifyEmail(user)

                        val userDB = user?.uid?.let { dbReference.child(it) }

                        userDB?.child("Name")?.setValue(name)
                        userDB?.child("Age")?.setValue(age)

                        action()
                    }
                }
        }else{
            Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyEmail(user : FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){
                task ->
                if(task.isSuccessful){
                    Toast.makeText(this, "Correo Enviado", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Error al enviar correo", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun action(){
        val createActivity = Intent(this, LoginActivity::class.java)
        startActivity(createActivity)
    }
}