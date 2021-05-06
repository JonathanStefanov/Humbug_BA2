package com.example.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceView
import model.Game

class DrawingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null,
                                             defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr){
    private val backgroundPaint = Paint()

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var level = Game.levels[Game.selectedLevel]

        // Drawing the background
        backgroundPaint.color = Color.WHITE
        canvas?.drawRect(0F, 0F, width.toFloat(), height.toFloat(),
            backgroundPaint)



        // Drawing the level
        level.drawLevel(canvas, this, height.toFloat())





    }


}