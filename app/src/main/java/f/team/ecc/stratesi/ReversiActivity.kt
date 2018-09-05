package f.team.ecc.stratesi

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.CompoundButton
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_reversi.*
import android.widget.Toast



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
            //置くコマを選択しないとコマを配置できない仕様
            if(imageView.getHeavy() != 0){
                onTouchEvent(motionEvent)
            }else{
                val toast = Toast.makeText(this@ReversiActivity, "コマを選択してください", Toast.LENGTH_SHORT)
                toast.show()
                true
            }
        })
        imageView.initBoard()
        ReversiView.TURN = true
        imageView.canPutStone(1)
        /**
         * PASSボタンの処理
         */
        turnButton.setOnClickListener {
            ReversiView.TURN = !ReversiView.TURN
            if(ReversiView.TURN){
                imageView.canPutStone(1)
                turnName.text = "黒の手番"
            }else{
                imageView.canPutStone(2)
                turnName.text = "白の手番"
            }
            imageView.invalidate()
        }
        oneButton.setOnCheckedChangeListener(
                CompoundButton.OnCheckedChangeListener { comButton, isChecked ->
                    var displayChar = ""
                    if (isChecked) {
                        displayChar = "1のコマを選択"
                        twoButton.isChecked = false
                        threeButton.isChecked = false
                        imageView.setHeavy(1)
                        val toast = Toast.makeText(this@ReversiActivity, displayChar, Toast.LENGTH_SHORT)
                        toast.show()
                    }else{
                        imageView.setHeavy(0)
                    }
                }
        )
        twoButton.setOnCheckedChangeListener(
                CompoundButton.OnCheckedChangeListener { comButton, isChecked ->
                    var displayChar = ""
                    if (isChecked) {
                        displayChar = "2のコマを選択"
                        oneButton.isChecked = false
                        threeButton.isChecked = false
                        imageView.setHeavy(2)
                        val toast = Toast.makeText(this@ReversiActivity, displayChar, Toast.LENGTH_SHORT)
                        toast.show()
                    }else{
                        imageView.setHeavy(0)
                    }
                }
        )
        threeButton.setOnCheckedChangeListener(
                CompoundButton.OnCheckedChangeListener { comButton, isChecked ->
                    var displayChar = ""
                    if (isChecked) {
                        displayChar = "3のコマを選択"
                        oneButton.isChecked = false
                        twoButton.isChecked = false
                        imageView.setHeavy(3)
                        val toast = Toast.makeText(this@ReversiActivity, displayChar, Toast.LENGTH_SHORT)
                        toast.show()
                    }else{
                        imageView.setHeavy(0)
                    }
                }
        )
    }
}
