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
    val backgroundPaint = Paint()
    //var square1: Square = Square(null)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        backgroundPaint.color = Color.WHITE
        canvas?.drawRect(0F, 0F, width.toFloat(), height.toFloat(),
            backgroundPaint)

       /* for(YSquares in Game.levels[Game.currentLevel].board.squares){
            for(XSquares in YSquares){
                XSquares?.draw(canvas, Position(i,j))
                i+=1
            }
            j += 1
        }

        for(var i = 0; i < Game.levels[Game.currentLevel].board.squares.size; i++){
                for(var j = 0; j < Game.levels[Game.currentLevel].board.squares[0].size; j++){
                Game.levels[Game.currentLevel].board.squares[i][j]
                var variable = Game.levels[Game.currentLevel].board.squares[i][j]
                variable.draw(canvas, Position(i,j)
            }
        }*/



        // Iteration on the 2D matrix
        Game.levels[Game.selectedLevel].board.squares.forEachIndexed { i, arrayOfSquares ->
            arrayOfSquares.forEachIndexed { j, square ->
                square?.draw(canvas, Position(j,i), this) // Drawing the squares
            }
        }
        /*
        for(i in 0..Game.levels[Game.currentLevel].board.squares.size){
             for(j in 0..Game.levels[Game.currentLevel].board.squares[i].size){
                Log.d("LOL", "i : $i j :$j")
        }
        }*/

        // Drawing characters
        for(character in Game.levels[Game.selectedLevel].characters){
            character.draw(canvas, this)
        }
        //Global.level0.board.squares[0][1].draw(canvas)
        // Updating the progressbar
        /*var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var currentLife = Game.levels[Game.selectedLevel].lifeBar
        ObjectAnimator.ofInt(progressBar, "Life", currentLife)
            .setDuration(1000)
            .start()*/


        // UI SECTION
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