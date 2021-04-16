package com.example.view

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceView
import android.widget.ProgressBar
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

        for(character in Game.levels[Game.selectedLevel].characters){
            character.draw(canvas, this)

        }
        //Global.level0.board.squares[0][1].draw(canvas)

        // Updating the progressbar
        /*var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.max = 10
        var currentLife = Game.levels[Game.selectedLevel].lifeBar
        ObjectAnimator.ofInt(progressBar, "Life", currentLife)
            .setDuration(1000)
            .start()*/









    }


}