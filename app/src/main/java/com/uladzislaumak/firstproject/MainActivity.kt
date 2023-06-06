package com.uladzislaumak.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

    fun menuButton(view: View) {
        Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
    }
}