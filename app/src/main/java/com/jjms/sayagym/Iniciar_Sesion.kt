package com.jjms.sayagym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Iniciar_Sesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        val atras=findViewById<Button>(R.id.sesion)
        atras.setOnClickListener {
            val lanzar = Intent(this,Iniciar_Sesion::class.java)
            startActivity(lanzar)
        }
    }
}