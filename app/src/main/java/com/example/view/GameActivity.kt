package com.example.view

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import model.*
import kotlin.math.abs


class GameActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    lateinit var drawingView: DrawingView
    lateinit var gestureDetector: GestureDetector
    var x1: Float = 0.0f
    var x0: Float = 0.0f
    var y1: Float = 0.0f
    var y0: Float = 0.0f
    lateinit var direction: Direction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels
        gestureDetector = GestureDetector(this, this)

        Game.screenHeight = height
        Game.screenWidth = width
        drawingView = findViewById(R.id.vMain)
        drawingView.setWillNotDraw(false)
        drawingView.invalidate()



        // Checking which Character is selected
        val radioGroup: RadioGroup = findViewById(R.id.radio_group)
        radioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { _, checkedId ->
                val selectedRadio: RadioButton = findViewById(checkedId)
                // Change selected character dynamically
                when(selectedRadio.text){
                    "Alain" -> Game.selectedCharacter = Game.levels[Game.selectedLevel].characters[0]
                    "Dylan" -> Game.selectedCharacter = Game.levels[Game.selectedLevel].characters[1]
                    "Jonathan" -> Game.selectedCharacter = Game.levels[Game.selectedLevel].characters[2]
                }

            })

        // Updating default selected character
        Game.selectedCharacter = Game.levels[Game.selectedLevel].characters[0]



    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
    override fun onShowPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
    }
    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }
    override fun onDown(e: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    // Swipe checking
    override fun onFling(moveEvent: MotionEvent, downEvent: MotionEvent, velocityX: Float, velocityY: Float): Boolean {

        var result: Boolean = false
        var diffY: Float = moveEvent.y - (downEvent.y)
        var diffX: Float = moveEvent.x - (downEvent.x)
        var direction: Direction? = null

        /*for (character in Game.levels[Game.currentLevel].characters) {
            if (character.shape.contains(downEvent.rawX,downEvent.rawY )) {
                Log.d("LOL", "CHAR TOU")
                Log.d("LOL", "x: ${downEvent.rawX } y: ${downEvent.rawY}")
            }
        }*/

        // Checking in which way the swipe has occurred
        if(abs(diffX) > abs(diffY)){
            // Left or right swipe check
            if(abs(diffX) > 100 && abs(velocityX) > 100){
                // TODO swipe right
                if(diffX > 0){
                    // left SWIPE
                    direction = Direction.LEFT
                    Log.d("LOL", "x: ${downEvent.rawX + 200} y: ${downEvent.rawY - 200 }")

                    result = true
                }
                else{
                    // rigt SWIPE
                    direction = Direction.RIGHT
                    result = true
                }

            }

        }
        else{
            // Up and down swipe
            if(abs(diffY) > 100 && abs(velocityY) > 100){
                if(diffY > 0){
                    // UP SWIPE
                    direction = Direction.UP
                    result = true
                }
                else{
                    // DOWN SWIPE
                    Log.d("LOL", "down")
                    direction = Direction.DOWN
                    Log.d("LOL", "x: ${downEvent.rawX } y: ${downEvent.rawY - 500}")
                    result = true
                }

            }

        }

        if (direction != null) {
            Game.selectedCharacter.move(direction, drawingView, this)
        }
        checkStatus()


        return result
    }
    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        //TODO("Not yet implemented")
        return false
    }
    override fun onLongPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
    }

    private fun startWinActivity(){
        val intent = Intent(this, WonActivity::class.java)
        this.startActivity(intent)
    }
    private fun startLostActivity(){
        val intent = Intent(this, LostActivity::class.java)
        this.startActivity(intent)
    }


    private fun checkCharacters() {
        // Checking if there still is a character on board
        var charactersOnBoard = false
        Game.levels[Game.selectedLevel].characters.forEach {character: Character ->
            if(character.position.x != -1 && character.position.y != -1){
                charactersOnBoard = true
            }
        }
        // Changing charactersOnBoard accordingly  accordingly
        Game.levels[Game.selectedLevel].charactersOnBoard = charactersOnBoard
    }

    private fun checkSquares() {
        // Checking is there still are target squares that havent been claimed
        var targetSquareOnBoard = false
        Game.levels[Game.selectedLevel].board.squares.forEach { arrayOfSquares ->
            arrayOfSquares.forEach { square ->
                if(square?.squareType == SquareType.TARGET){
                    targetSquareOnBoard = true
                }
            }
        }
        // Changing squaresOnBoard accordingly
        Game.levels[Game.selectedLevel].targetSquaresOnBoard = targetSquareOnBoard
    }


    private fun wonLevel(){
        startWinActivity()
        Game.levels[Game.selectedLevel] = Game.untouchedLevels[Game.selectedLevel] // Reset level
    }
    private fun lostLevel(){
        startLostActivity()
        Game.levels[Game.selectedLevel] = Game.untouchedLevels[Game.selectedLevel] // Reset level
    }


    private fun checkStatus() {

        /*/ Using a coroutine to optimize the checking process
        val job =  GlobalScope.launch { checkCharacters() }
        checkSquares()
        job.join() // at this point, both checks are done*/
        runBlocking {
            launch { checkSquares() }
            launch { checkCharacters() }
        }
        checkSquares()
        checkCharacters()
        // TODO : check for moves and life jleft as well
        if (Game.levels[Game.selectedLevel].lifeBar > 0 && Game.levels[Game.selectedLevel].movesLeft > 0) {
            if (Game.levels[Game.selectedLevel].charactersOnBoard) {
                // If there is characters on board, check if all squares have been claimed
                if (!Game.levels[Game.selectedLevel].targetSquaresOnBoard) {
                    // If there is no target squares anymore, it me+ans that they have all bene claimed
                    wonLevel()
                }
            } else {
                lostLevel()
            }
        } else {
            lostLevel()

        }
    }






}