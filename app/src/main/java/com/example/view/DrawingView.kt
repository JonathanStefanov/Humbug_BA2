package com.example.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.SurfaceView
import model.Game
import model.Position

class DrawingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null,
                                             defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr){
    private val backgroundPaint = Paint()

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Drawing the background
        backgroundPaint.color = Color.WHITE
        canvas?.drawRect(0F, 0F, width.toFloat(), height.toFloat(),
            backgroundPaint)

        // Iteration on the 2D matrix
        Game.levels[Game.selectedLevel].board.squares.forEachIndexed { i, arrayOfSquares ->
            arrayOfSquares.forEachIndexed { j, square ->
                square?.drawSquare(canvas, Position(j,i), this) // Drawing the squares
            }
        }

        // Drawing characters
        for(character in Game.levels[Game.selectedLevel].characters){
            character.drawCharacter(canvas, this)
        }

        // Drawing the UI
        this.drawUI(canvas)




    }
    private fun drawUI(canvas: Canvas?){
        // Drawing life left text
        val paint = Paint()
        var color = Color.BLACK
        paint.color = color
        paint.textSize = 60F;

        // Drawing the Moves left
        canvas?.drawText("Moves Left : " + Game.levels[Game.selectedLevel].movesLeft.toString(), 200f, height.toFloat() - 250, paint);
        // drawing life left text
        canvas?.drawText("Life : ", 200f, height.toFloat() - 150, paint);

        // Drawing the life points
        paint.color = Color.BLUE
        for(i in 0 until Game.levels[Game.selectedLevel].lifeBar){
            canvas?.drawCircle(400f + i.toFloat()*110, height.toFloat() - 180, 30f, paint);
        }





    }


}