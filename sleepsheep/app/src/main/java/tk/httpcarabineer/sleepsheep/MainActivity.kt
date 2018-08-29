package tk.httpcarabineer.sleepsheep

import android.content.SharedPreferences
import android.graphics.Color
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var sheepCount = 0
    var mp: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var greeting = "こんにちは"
        val trialTime = Date()
        val calendar = GregorianCalendar()
        calendar.time = trialTime

        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        if (hour in 1..11) {
            greeting = "おはよう"
        } else if (15 < hour) {
            greeting = "こんばんは"
        }

//        val sheepNum = 10
//        for (i in 1..sheepNum) {
//            greeting += "。。。ひつじが" + i + "匹"
//        }

        greeting += "ねむれませんか？"

        textview.text = greeting

        mp = MediaPlayer.create(applicationContext, R.raw.sheep_cry1)

        rootLayout.setOnClickListener {
            sheepCount++
            val sheepText = "ひつじが$sheepCount 匹"
            textview.text = sheepText

            when(sheepCount % 3) {
                0 -> {
                    imageView1.setImageResource(R.drawable.blue)
//                    rootLayout.setBackgroundColor(Color.WHITE)
//                    textview.setTextColor(Color.GRAY)
                    mp?.start()

                }
                1 -> {
                    imageView1.setImageResource(R.drawable.red)
                    mp?.start()

                }
                else -> {
                    imageView1.setImageResource(R.drawable.green)
                    mp?.start()
                }
            }
        }
    }

    // スリープから回復してきた時に呼び出される処理
    override fun onPause() {
        super.onPause()
        Log.i("onPause", "眠るまでの回数=$sheepCount")
        //値を保存する
        val sp: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        sp.edit().putInt("SheepCount", sheepCount).apply()
    }
    //スリープから回復した時に呼び出される処理を追加する
    override fun onResume() {
        super.onResume()
        //値を読み出す
        val sp: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val count = sp.getInt("SheepCount", -1)
        if (count >= 0) {
            textview.text = "前回は$count 回羊を数えました。"
        }
    }
}
