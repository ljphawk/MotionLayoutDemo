package com.qszx.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.qszx.myapplication.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


    }

    fun cardAnim(view: View) {
        startActivity(Intent(this, CardActivity::class.java))
    }

    fun menuAnim(view: View) {
        startActivity(Intent(this, MenuActivity::class.java))

    }
    fun bannerAnim(view: View) {
        startActivity(Intent(this, BannerActivity::class.java))

    }


}