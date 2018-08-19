package tk.httpcarabineer.discal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.b_keisann)

        button.setOnClickListener {

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

                //ResultActivityの呼び出し
                startActivity(intent)

                //計算結果を表示
//                val set_kekka = findViewById<TextView>(R.id.tv_kekka_disp)
//                set_kekka.text = getString(R.string.set_kekka,kekka)

                //税込計算結果を表示
//                val set_kekka_zeikomi = findViewById<TextView>(R.id.tv_kekka_zeikomi_disp)
//                set_kekka_zeikomi.text = getString(R.string.set_kekka_zeikomi,kekka_zeikomi)
            }
        }
    }
}
