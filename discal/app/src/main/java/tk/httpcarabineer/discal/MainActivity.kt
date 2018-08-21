package tk.httpcarabineer.discal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.*

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713")
        MobileAds.initialize(this, "ca-app-pub-5534482245506618~5167709541")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        //選択ボタン 1 ---ここから
        val button_1 = findViewById<Button>(R.id.button_1)




        //選択ボタン ％引------------------------------------------------------
        val button_0 = findViewById<Button>(R.id.button_0)

        //計算用ボタン
        val b_keisann_1 = findViewById<Button>(R.id.b_keisann_1)

        //％引
        val et_offprice = findViewById<TextView>(R.id.et_offprice)
        val tx_offprice = findViewById<TextView>(R.id.tx_offprice)

        //％引非表示
        et_offprice.visibility = View.INVISIBLE
        tx_offprice.visibility = View.INVISIBLE
        b_keisann_1.visibility = View.INVISIBLE

        button_0.setOnClickListener {

            //％引表示
            et_offprice.visibility = View.VISIBLE
            tx_offprice.visibility = View.VISIBLE
            b_keisann_1.visibility = View.VISIBLE

            //計算ボタンをクリックしたら
            b_keisann_1.setOnClickListener {

                //未入力判定のフラグ
                var isValid = true
                //金額入力欄の値を取得
                val get_price = findViewById<EditText>(R.id.et_price)
                val st_price = get_price.text.toString()
                //合計金額が空欄になっていないかチェック
                if(st_price.isEmpty()){
                    get_price.error = getString(R.string.et_price_error)
                    isValid = false
                }

                //オフ率
                val get_offprice = findViewById<EditText>(R.id.et_offprice)
                val st_offprice = get_offprice.text.toString()
                //オフ率が空欄になっていないかをチェック
                if(st_offprice.isEmpty()) {
                    //オフ率が未入力の場合
                    get_offprice.error = getString(R.string.et_offprice_error)
                    isValid = false
                }

                //金額入力欄、オフ率入力欄に値が入っている場合
                if(isValid) {
                    //計算
                    val goukei_price:Float = st_price.toFloat()
                    val off_price:Float = st_offprice.toFloat()
                    val keisan:Float = goukei_price-(goukei_price*(off_price/100))
                    val kekka = keisan.toInt()
                    val kekka_zeikomi_keisan:Float = (keisan*1.08).toFloat()
                    val kekka_zeikomi = kekka_zeikomi_keisan.toInt()

                    //ResultActivityに値を引き継ぎ
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("kekka", kekka)
                    intent.putExtra("kekka_zeikomi", kekka_zeikomi)

                    //金額・オフ率のEditTextを初期化
                    get_price.text.clear()
                    get_offprice.text.clear()

                    //非表示に戻す
                    et_offprice.visibility = View.INVISIBLE
                    tx_offprice.visibility = View.INVISIBLE

                    //ResultActivityの呼び出し
                    startActivity(intent)

                }
            }
        }//選択ボタン ％引 ここまで------------------------------------------------------


    }
}
