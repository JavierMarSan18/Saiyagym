package com.jjms.sayagym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sesion = findViewById<Button>(R.id.btnISesion)

        //Lanzar activity de inicio de sesión
        sesion.setOnClickListener {
            val lanzar = Intent(this,Iniciar_Sesion::class.java)
            startActivity(lanzar)
        }
    }
}