package com.example.view

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import model.Character
import model.Direction
import model.Game
import kotlin.math.abs


class GameActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    lateinit var drawingView: DrawingView
    lateinit var gestureDetector: GestureDetector
    var x1: Float = 0.0f
    var x0: Float = 0.0f
    var y1: Float = 0.0f
    var y0: Float = 0.0f
    lateinit var direction: Direction
    companion object{
        const val MIN_DISTANCE = 150
    }
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
                    "Jonathan" -> Game.selectedCharacter = Game.levels[Game.selectedLevel].characters[1]
                }

            })

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
        Log.d("Alain",moveEvent.x.toString());
        Log.d("Alain",moveEvent.y.toString());
        Log.d("Alain",downEvent.x.toString());
        Log.d("Alain",downEvent.y.toString());
        var result: Boolean = false
        var diffY: Float = moveEvent.y - (downEvent.y)
        var diffX: Float = moveEvent.x - (downEvent.x)
        var chosenCharacter: Character? = null
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


        return result
    }
    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        //TODO("Not yet implemented")
        return false
    }
    override fun onLongPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
    }



}