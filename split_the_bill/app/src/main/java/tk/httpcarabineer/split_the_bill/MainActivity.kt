package tk.httpcarabineer.split_the_bill

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.b_keisann)
        button.setOnClickListener {
            //ここに計算ボタンがタップされた時の処理を書く

            //未入力判定用のフラグ
            var isValid = true


            //合計金額入力欄の値を取得
            val get_goukei = findViewById<EditText>(R.id.et_goukei)
            val st_goukei = get_goukei.text.toString()

            //合計金額入力欄が空欄になっていないかをチェック
            if(st_goukei.isEmpty()) {
                get_goukei.error = getString(R.string.et_goukei_error)
                isValid = false
            }


            //人数入力欄の値を取得
            val get_ninnzuu = findViewById<EditText>(R.id.et_ninnzuu)
            val st_ninnzuu = get_ninnzuu.text.toString()

            //人数入力欄が空欄になっていないかをチェック
            if(st_ninnzuu.isEmpty()) {
                //人数が未入力の場合
                get_ninnzuu.error = getString(R.string.et_ninnzuu_error)
                isValid = false
            }


            //合計金額入力欄、人数入力欄に値が入っている場合
            if(isValid) {
                //合計金額入力欄、人数入力欄の値を文字列型から整数型に変換
                val goukei = Integer.parseInt(st_goukei)
                val ninnzuu = Integer.parseInt(st_ninnzuu)

                //計算
                val kekka = goukei / ninnzuu

                //1人分の金額表示欄を取得して、計算結果を表示
                val set_kekka = findViewById<TextView>(R.id.tv_kekka_disp)
                set_kekka.text = getString(R.string.set_kekka, kekka)
            }
        }
    }
}
