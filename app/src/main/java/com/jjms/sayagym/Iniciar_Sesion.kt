package com.jjms.sayagym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Iniciar_Sesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        val atras=findViewById<Button>(R.id.atras)
        atras.setOnClickListener {
            val lanzar = Intent(this,MainActivity::class.java)
            startActivity(lanzar)
        }
    }
}