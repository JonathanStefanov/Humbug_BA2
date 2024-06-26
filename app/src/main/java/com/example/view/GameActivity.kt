package com.example.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import model.*
import kotlin.math.abs
import kotlin.properties.Delegates


class GameActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    lateinit var drawingView: DrawingView
    lateinit var gestureDetector: GestureDetector
    lateinit var direction: Direction
    var level = Game.levels[Game.selectedLevel]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)


        gestureDetector = GestureDetector(this, this) // Setting up gesture detector



        drawingView = findViewById(R.id.vMain)
        drawingView.setWillNotDraw(false)
        drawingView.invalidate()



        // Checking which Character is selected
        val radioGroup: RadioGroup = findViewById(R.id.radio_group)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedRadio: RadioButton = findViewById(checkedId)
            // Change selected character dynamically
            when(selectedRadio.text){
                "Alain" -> Game.selectedCharacter = level.characters[0]
                "Dylan" -> Game.selectedCharacter = level.characters[1]
                "Jonathan" -> Game.selectedCharacter = level.characters[2]
            }

        }

        // Updating default selected character
        Game.selectedCharacter = level.characters[0]



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


        // Checking in which way the swipe has occurred
        if(abs(diffX) > abs(diffY)){
            // Left or right swipe check
            if(abs(diffX) > 60 && abs(velocityX) > 50){
                // TODO swipe right
                if(diffX > 0){
                    // left SWIPE
                    direction = Direction.LEFT
                    result = true
                }
                else{
                    // right SWIPE
                    direction = Direction.RIGHT
                    result = true
                }

            }

        }
        else{
            // Up and down swipe
            if(abs(diffY) > 60 && abs(velocityY) > 50){
                if(diffY > 0){
                    // UP SWIPE
                    direction = Direction.UP
                    result = true
                }
                else{
                    // DOWN SWIPE
                    direction = Direction.DOWN
                    result = true
                }

            }

        }

        // Calling the move function of the selected character in the direction of the swipe
        if (direction != null) {

            var canMove:Boolean = Game.selectedCharacter.move(direction, level)
            if(canMove){
                level.decreaseMove()
                drawingView.invalidate()
            }
            else{
                // cannot move
                val vibrator =
                    getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(
                        VibrationEffect.createOneShot(
                            200,
                            VibrationEffect.DEFAULT_AMPLITUDE
                        )
                    )
                } else {
                    vibrator.vibrate(200)
                }
            }
        }
        var levelStatus = level.checkStatus()
        when(levelStatus){
            LevelStatus.FAIL -> {
                Game.levels[Game.selectedLevel] = Game.untouchedLevels[Game.selectedLevel] // Reset level
                startLostActivity()
            }
            LevelStatus.WON -> startWinActivity()
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

    private fun startWinActivity(){
        val intent = Intent(this, WonActivity::class.java)
        this.startActivity(intent)
    }
    private fun startLostActivity(){
        val intent = Intent(this, LostActivity::class.java)
        this.startActivity(intent)
    }

}





