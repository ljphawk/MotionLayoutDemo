package com.qszx.myapplication.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.qszx.myapplication.CustomConstraintLayout
import com.qszx.myapplication.R
import com.qszx.myapplication.SelfDrawerLayout


/*
 *@创建者       L_jp
 *@创建时间     2022/1/19 09:28.
 *@描述
 */
class MenuActivity : ComponentActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu)

        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)
        val drawerLayout = findViewById<SelfDrawerLayout>(R.id.drawerLayout)

        val clLayout1 = findViewById<CustomConstraintLayout>(R.id.clLayout1)
        val clLayout2 = findViewById<CustomConstraintLayout>(R.id.clLayout2)
        val clLayout3 = findViewById<CustomConstraintLayout>(R.id.clLayout3)

        drawerLayout.setScrimColor(Color.TRANSPARENT)
        drawerLayout.addDrawerListener(object : SelfDrawerLayout.SimpleDrawerListener() {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                motionLayout.progress = slideOffset
                clLayout1.setRadius(slideOffset)
                clLayout2.setRadius(slideOffset)
                clLayout3.setRadius(slideOffset)
            }

        })

        findViewById<Button>(R.id.button).setOnClickListener {
            if (drawerLayout.isDrawerOpen(Gravity.START)) {
                drawerLayout.closeDrawer(Gravity.START)
            } else {
                drawerLayout.openDrawer(Gravity.START)
            }
        }
    }
}