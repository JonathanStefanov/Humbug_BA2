package model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Handler
import com.example.view.DrawingView
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Level(var movesLeft: Int, var lifeBar: Int, var characters: Array<Character>, var status: LevelStatus,
            var squares: Array<Array<out Square?>>, var charactersOnBoard: Boolean = true, var targetSquaresOnBoard: Boolean = true){

    fun drawLevel(
        canvas: Canvas?,
        drawingView: DrawingView,
        height: Float) {
        // Iteration on the 2D matrix
        this.squares.forEachIndexed { i, arrayOfSquares ->
            arrayOfSquares.forEachIndexed { j, square ->
                square?.drawSquare(canvas, arrayOf(j,i), drawingView) // Drawing the squares
            }
        }

        // Drawing characters
        for(character in this.characters){
            character.drawCharacter(canvas, drawingView)
        }

        // Drawing life left text
        val paint = Paint()
        var color = Color.BLACK
        paint.color = color
        paint.textSize = 60F;

        // Drawing the Moves left
        canvas?.drawText("Moves Left : " + this.movesLeft.toString(), 200f, height.toFloat() - 250, paint);
        // drawing life left text
        canvas?.drawText("Life : ", 200f, height.toFloat() - 150, paint);

        // Drawing the life points
        paint.color = Color.BLUE
        for(i in 0 until this.lifeBar){
            canvas?.drawCircle(400f + i.toFloat()*110, height.toFloat() - 180, 30f, paint);
        }


    }

    private fun checkRemainingSquares() {
        // Checking is there still are target squares that haven't been claimed
        var targetSquareOnBoard = false
        this.squares.forEach { arrayOfSquares ->
            arrayOfSquares.forEach { square ->
                if(square?.squareType == SquareType.TARGET){
                    targetSquareOnBoard = true
                }
            }
        }
        // Changing squaresOnBoard accordingly
       this.targetSquaresOnBoard = targetSquareOnBoard
    }

    private fun checkCharacters() {
        Handler().postDelayed(
            {
                // Checking if there still is a character on board
                var charactersOnBoard = false
                this.characters.forEach {character: Character ->
                    if(character.position[0]!= -1 && character.position[1] != -1){
                        charactersOnBoard = true
                    }
                }
                // Changing charactersOnBoard accordingly  accordingly
                this.charactersOnBoard = charactersOnBoard
            },
            10 // Function will be executed 10ms after the checkSquares, otherwise it causes bug
        )

    }


    fun getSquareFromPosition(position: Array<Int>): Square? {return squares.elementAtOrNull(position[1])?.elementAtOrNull(position[0])}

    fun checkStatus() : LevelStatus {
        // Checking at the same time if there still are characters on the board and if there
        // are still unclaimed target squares using Kotlin coroutines
        runBlocking {
            launch { checkRemainingSquares() }
            launch { checkCharacters() }
        }

        if (this.lifeBar > 0 && this.movesLeft > 0) {
            if (this.charactersOnBoard) {
                // If there is characters on board, check if all squares have been claimed
                if (!this.targetSquaresOnBoard) {
                    // If there is no target squares anymore, it me+ans that they have all been claimed
                    this.status = LevelStatus.WON
                }
            } else {
                this.status = LevelStatus.FAIL
            }
        } else {
            this.status = LevelStatus.FAIL


        }
        return this.status
    }

    fun decreaseMove(){
        this.movesLeft = this.movesLeft - 1
    }

    fun decreaseLife(nbr: Int){
        this.lifeBar = this.lifeBar - nbr
    }

}
