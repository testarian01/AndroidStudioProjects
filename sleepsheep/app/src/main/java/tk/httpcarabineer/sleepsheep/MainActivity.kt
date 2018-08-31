package tk.httpcarabineer.sleepsheep

import android.content.Intent
import android.content.SharedPreferences
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-5534482245506618~7477363441")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        var greeting = "こんにちは。"
        val trialTime = Date()
        val calendar = GregorianCalendar()
        calendar.time = trialTime

        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        if (hour in 1..11) {
            greeting = "おはようございます。"
        } else if (15 < hour) {
            greeting = "こんばんは。"
        }

        textview.text = greeting

        textview2.text = "羊を数えてみましょう。"

        sleep_btn.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }
    }

    //スリープから回復した時に呼び出される処理を追加する
    override fun onResume() {
        super.onResume()
        //値を読み出す
        val sp: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val count = sp.getInt("SheepCount", -1)
        if (count >= 0) {
            textview2.text = "前回は$count 回羊を数えました。"
        }
    }
}