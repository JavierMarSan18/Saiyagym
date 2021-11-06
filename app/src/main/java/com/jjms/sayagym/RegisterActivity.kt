package com.jjms.sayagym

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class RegisterActivity : AppCompatActivity() {

    private lateinit var txtEmail : EditText
    private lateinit var txtPassword : EditText
    private lateinit var trainer : String
    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var dbReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

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
        val email = txtEmail.text.toString()
        val password = txtPassword.text.toString()

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(trainer)){
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){
                    task ->
                    if(task.isSuccessful){
                        val user : FirebaseUser? = auth.currentUser
                        verifyEmail(user)

                        val userBD = user?.uid?.let { dbReference.child(it) }
                        userBD?.child("Trainer")?.setValue(trainer)

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

    fun onClickTAzu(view: android.view.View) {
        trainer = "Azucena"
        Toast.makeText(this, "Entrenador Seleccionado", Toast.LENGTH_SHORT).show()
    }
    fun onClickTOsman(view: android.view.View) {
        trainer = "Osman"
        Toast.makeText(this, "Entrenador Seleccionado", Toast.LENGTH_SHORT).show()
    }
    fun onClickTJavier(view: android.view.View) {
        trainer = "Javier"
        Toast.makeText(this, "Entrenador Seleccionado", Toast.LENGTH_SHORT).show()
    }
}