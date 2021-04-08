package com.example.humbug

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import model.Direction
import model.Game


class MainActivity : AppCompatActivity(),GestureDetector.OnGestureListener {
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


        // Testing which character has been clicked
        for(character in Game.levels[Game.currentLevel].characters){
            if(character.shape.contains(x0, y0)){
                character.move(direction = direction)
            }




        }
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
    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        //TODO("Not yet implemented")
        return false
    }
    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        //TODO("Not yet implemented")
        return false
    }
    override fun onLongPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
    }



}
