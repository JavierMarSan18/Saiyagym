package com.jjms.sayagym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class registrarse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        val atras2=findViewById<Button>(R.id.atras2)
        atras2.setOnClickListener {
            val lanzar = Intent(this,MainActivity::class.java)
            startActivity(lanzar)
     }
    }
}