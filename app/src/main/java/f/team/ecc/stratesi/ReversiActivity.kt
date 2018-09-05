package f.team.ecc.stratesi

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_reversi.*

class ReversiActivity : AppCompatActivity() {
    companion object {
        var row = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //画面を縦方向で固定する
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_reversi)

        imageView.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            onTouchEvent(motionEvent)
        })
        imageView.initBoard()
        ReversiView.TURN = true
        imageView.canPutStone(1)
        turnButton.setOnClickListener {
            ReversiView.TURN = !ReversiView.TURN
            if(ReversiView.TURN){
                imageView.canPutStone(1)
            }else{
                imageView.canPutStone(2)
            }
            imageView.invalidate()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}
