package com.qszx.myapplication.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.qszx.myapplication.R


/*
 *@创建者       L_jp
 *@创建时间     2022/1/18 10:22.
 *@描述
 */
class CardActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_card)

        val constraintLayout = findViewById<MotionLayout>(R.id.constraintLayout)

        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)

        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                layout: MotionLayout?,
                beginState: Int,
                endState: Int
            ) {
                Log.d("=== Started", "beginState = $beginState  endState = $endState")
            }

            override fun onTransitionChange(
                layout: MotionLayout?,
                beginState: Int,
                endState: Int,
                transitionPosition: Float
            ) {
                Log.d(
                    "=== Change",
                    "beginState = $beginState  endState = $endState  transitionPosition = $transitionPosition"
                )
                if (transitionPosition == 0f) {
                    constraintLayout.transitionToStart()
                } else if (transitionPosition == 1f) {
                    constraintLayout.transitionToEnd()
                }
            }

            override fun onTransitionCompleted(layout: MotionLayout?, state: Int) {
                Log.d("=== Completed", "$state")
            }

            override fun onTransitionTrigger(
                layout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
                Log.d(
                    "=== Trigger",
                    "triggerId = $triggerId  positive = $positive  progress = $progress"
                )
            }

        })


    }
}