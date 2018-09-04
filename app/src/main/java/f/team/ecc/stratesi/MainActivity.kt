package f.team.ecc.stratesi

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        multiBattleButton.setOnClickListener {

        }

        onlineBattleButton.setOnClickListener {

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
