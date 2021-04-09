package com.example.view

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import model.Direction
import model.Game
import kotlin.math.abs


class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
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
        setContentView(R.layout.activity_main)

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


        /*val p1 = Haelterman(arrayOf<Int>(0,0))
        p1.moveTop()
        p1.moveLeft()
        Log.d("pos", "x : " + p1.position[0].toString() + " y : " + p1.position[1].toString())*/


        /*var board = Board(
            arrayOf(
                arrayOf(GrassSquare(null), StarSquare(null)),
                arrayOf(
                    GrassSquare(null),
                    GrassSquare(null)
                )
            )
        )*/

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        /*


        gestureDetector.onTouchEvent(event)
        // Test for the swipe directon
        when (event?.action){
            0 ->{
                x0 = event.x
                y0 = event.y
            }
            1 ->{
                x1 = event.x
                y1 =event.y
                val valueX:Float = x1-x0
                val valueY:Float = y1-y0
                if (kotlin.math.abs(valueX) > MIN_DISTANCE){
                    if (x1 > x0){
                        var direction = Direction.RIGHT
                    }
                    else {
                        var direction = Direction.LEFT
                    }
                }
                else if (kotlin.math.abs(valueY) > MIN_DISTANCE){
                    if (y1 > y0){
                        var direction = Direction.DOWN
                    }
                    else {
                        var direction = Direction.UP
                    }
                }
            }





        }

        if(event?.action == MotionEvent.ACTION_DOWN) {
            // Testing which character has been clicked
            val x = event.rawX - 100
            val y = event.rawY - 300
            for (character in Game.levels[Game.currentLevel].characters) {
                if (character.shape.contains(x,y)) {
                    Log.d("LOL", "CHAR TOU")
                    character.move(direction)
                }
            }
        }


 */
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
        var diffY: Float = moveEvent.y.minus(downEvent.y)
        var diffX: Float = moveEvent.x.minus(downEvent.x)

        for (character in Game.levels[Game.currentLevel].characters) {
            if (character.shape.contains(downEvent.x - 100,downEvent.y - 100)) {
                Log.d("LOL", "CHAR TOU")
            }
        }
        // Checking in which way the swipe has occurred
        if(abs(diffX) > abs(diffY)){
            // Left or right swipe check
            if(abs(diffX) > 100 && abs(velocityX) > 100){
                // TODO swipe right
                if(diffX > 0){
                    // RIGHT SWIPE
                    Log.d("LOL", "right")
                    result = true
                }
                else{
                    // LEFT SWIPE
                    // TODO left swipe
                    Log.d("LOL", "left")
                    result = true
                }

            }

        }
        else{
            // Up and down swipe
            if(abs(diffY) > 100 && abs(velocityY) > 100){
                // TODO swipe up
                if(diffY > 0){
                    // UP SWIPE
                    Log.d("LOL", "uyp")
                    result = true
                }
                else{
                    // DOWN SWIPE
                    Log.d("LOL", "down")
                    result = true
                }

            }
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
