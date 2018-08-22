package tk.httpcarabineer.discal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class ResultActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

//        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713")
        MobileAds.initialize(this, "ca-app-pub-5534482245506618~5167709541")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        //前画面からint型に変換した値を受け取る
        val kekka = intent.getIntExtra("kekka", 0)
        val kekka_zeikomi = intent.getIntExtra("kekka_zeikomi", 0)

        //１人分の支払い金額を表示
        //計算結果を表示
                val set_kekka = findViewById<TextView>(R.id.tv_kekka_disp)
                set_kekka.text = getString(R.string.set_kekka,kekka)

        //税込計算結果を表示
                val set_kekka_zeikomi = findViewById<TextView>(R.id.tv_kekka_zeikomi_disp)
                set_kekka_zeikomi.text = getString(R.string.set_kekka_zeikomi,kekka_zeikomi)

        //もう１回計算ボタンをタップした時の処理
        val restart = findViewById<Button>(R.id.b_restart)

        restart.setOnClickListener {
            //ResultActivityを終了させる
            finish()
        }
    }
}
