package tk.carabineer.toukenlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class SecondActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        MobileAds.initialize(this, "ca-app-pub-5534482245506618~9002986464")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        //戻るボタンの実装
        var greeting = "リストに戻る"
        returnButton.text = greeting

        returnButton.setOnClickListener {
            finish()
        }

        val text1 = intent.getStringExtra("bunrui")
        val text2 = intent.getStringExtra("touha")
        val text3 = intent.getStringExtra("name")
        val text4 = intent.getStringExtra("nameyomi")
        val text5 = intent.getStringExtra("bikou")

        val messageView1: TextView = findViewById(R.id.message_view1)
        val messageView2: TextView = findViewById(R.id.message_view2)
        val messageView3: TextView = findViewById(R.id.message_view3)
        val messageView4: TextView = findViewById(R.id.message_view4)
        val messageView5: TextView = findViewById(R.id.message_view5)

        messageView1.text = text1
        messageView2.text = text2
        messageView3.text = text3
        messageView4.text = text4
        messageView5.text = text5

    }
}
