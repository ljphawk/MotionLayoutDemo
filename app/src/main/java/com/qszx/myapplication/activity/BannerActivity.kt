package com.qszx.myapplication.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.helper.widget.Carousel
import com.qszx.myapplication.R


/*
 *@创建者       L_jp
 *@创建时间     2022/1/21 10:23.
 *@描述

 * 这个是掘金上搬过来的,不是本人的代码
 */
class BannerActivity : ComponentActivity() {

    var images = intArrayOf(
        R.drawable.card1,
        R.drawable.card2,
        R.drawable.card3,
        R.drawable.card4,
        R.drawable.card5
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_banner)


        val carsoul = findViewById<Carousel>(R.id.carousel)
        carsoul.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return images.size
            }

            override fun populate(view: View?, index: Int) {
                if (view is ImageView) {
                    view.setImageResource(images[index])
                }
            }

            override fun onNewItem(index: Int) {
                // called when an item is set
            }
        })
    }
}