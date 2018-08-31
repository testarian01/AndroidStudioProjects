package tk.httpcarabineer.sleepsheep

import android.content.SharedPreferences
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_result.*

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class ResultActivity : AppCompatActivity() {

    var sheepCount = 0
    var mp: MediaPlayer? = null

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        MobileAds.initialize(this, "ca-app-pub-5534482245506618~7477363441")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        textview3.text = "タップして羊を数えます。"

        mp = MediaPlayer.create(applicationContext, R.raw.sheep_cry1)

        val animation = AnimationUtils.loadAnimation(this, R.anim.translate_animation);

        rootLayout.setOnClickListener {
            sheepCount++
            val sheepText = "ひつじが$sheepCount 匹"
            textview3.text = sheepText

            when(sheepCount % 3) {
                0 -> {
                    imageView1.setImageResource(R.drawable.blue)
                    imageView1.startAnimation(animation);
                    mp?.start()

                }
                1 -> {
                    imageView1.setImageResource(R.drawable.red)
                    imageView1.startAnimation(animation);
                    mp?.start()

                }
                else -> {
                    imageView1.setImageResource(R.drawable.green)
                    imageView1.startAnimation(animation);
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
}
