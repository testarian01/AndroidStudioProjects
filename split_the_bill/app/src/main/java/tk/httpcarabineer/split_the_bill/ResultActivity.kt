package tk.httpcarabineer.split_the_bill

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        //前画面からint型に変換した値を受け取る
        val goukei = intent.getIntExtra("goukei", 0)
        val ninnzuu = intent.getIntExtra("ninnzuu", 0)
        val tyousei = intent.getIntExtra("tyousei", 0)

        //1人分の支払い金額と端数の計算
        val kekka = (goukei - tyousei) / ninnzuu
        val hasuu = (goukei - tyousei) % ninnzuu

        //１人分の支払い金額を表示
        val set_kekka1 = findViewById<TextView>(R.id.tv_kekka1_disp)
        set_kekka1.text = Html.fromHtml(getString(R.string.set_kekka1, kekka))

        if(hasuu != 0) {
            //端数が0の場合に表示
            val set_hasuu_ari = findViewById<TextView>(R.id.tv_kekka2_disp)
            set_hasuu_ari.text = Html.fromHtml(getString(R.string.set_hasuu_ari, hasuu))

        }else{
            //端数が0以外なら端数の金額を表示
            val set_hasuu_nasi = findViewById<TextView>(R.id.tv_kekka2_disp)
            set_hasuu_nasi.text = getString(R.string.set_hasuu_nasi)
        }

        //もう１回計算ボタンをタップした時の処理
        val restart = findViewById<Button>(R.id.b_restart)
        restart.setOnClickListener {
            //ResultActivityを終了させる
            finish()
        }
    }
}