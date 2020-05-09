package com.example.lab6_7kotlin.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6_7kotlin.R


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    fun toMainButton(view: View?): Unit {
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
    }

    fun toBackendButton(view: View?) {
        val intent = Intent(this, BackendActivity::class.java)
        this.startActivity(intent)
    }
}