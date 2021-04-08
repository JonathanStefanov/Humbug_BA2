package com.example.humbug

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceView
import model.Global
import model.Square

class DrawingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null,
                                             defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr){
    val backgroundPaint = Paint()
    //var square1: Square = Square(null)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        backgroundPaint.color = Color.WHITE
        canvas?.drawRect(0F, 0F, width.toFloat(), height.toFloat(),
            backgroundPaint)


        Global.level0.board.squares[0][1].draw(canvas)
        //Global.level0.board.squares[0][1].draw(canvas)











    }
}