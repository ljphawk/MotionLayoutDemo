package com.qszx.myapplication

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat


/*
 *@创建者       L_jp
 *@创建时间     2022/1/19 11:15.
 *@描述
 */
class CustomConstraintLayout(context: Context, attributeSet: AttributeSet? = null) :
    ConstraintLayout(context, attributeSet) {

    private val path = Path()
    private val rectF = RectF()
    private var radius = 0f

    private var drawPath = false

    fun setRadius(r: Float) {
        val dp10 = dip2px(10f)
        var dp = dip2px(r * 10) //最多10
        drawPath = true
        if (dp > dp10) {
            dp = dp10
        } else if (dp < 0f) {
            dp = 0f
            drawPath = false
        }
        radius = dp

        path.reset()
        path.addRoundRect(rectF, radius, radius, Path.Direction.CW);
        invalidate()
    }

    private val scale = Resources.getSystem().displayMetrics.density
    private fun dip2px(dipValue: Float): Float {
        return (dipValue * scale + 0.5f)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rectF.set(0f, 0f, w.toFloat(), h.toFloat());
    }

    override fun draw(canvas: Canvas) {
        if (!drawPath) {
            super.draw(canvas)
        } else {
            val saveCount = canvas.save()
            canvas.clipPath(path)
            super.draw(canvas)
            canvas.restoreToCount(saveCount)
        }
    }
}