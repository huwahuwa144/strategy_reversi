package f.team.ecc.stratesi

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        multiBattleButton.setOnClickListener {
            //画面を遷移
            val reversiIntent = Intent(this, ReversiActivity::class.java)
            startActivity(reversiIntent)
        }

        onlineBattleButton.setOnClickListener {
            val reversiIntent = Intent(this, ReversiActivity::class.java)
            startActivity(reversiIntent)
        }

        rankingButton.setOnClickListener {

        }

        settingButton.setOnClickListener {

        }
    }

    /**
     * BootStrap用
     */
    override fun attachBaseContext(newBase: Context){
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}
