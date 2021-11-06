package com.jjms.sayagym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var trainer: Trainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickPersonal(view: android.view.View) {
        startActivity(Intent(this,PersonalActivity::class.java))
    }
    fun onClickCoaching(view: android.view.View) {
        startActivity(Intent(this,CoachingActivity::class.java))
    }
    fun onClickNutrition(view: android.view.View) {
        startActivity(Intent(this,NutritionActivity::class.java))
    }
}