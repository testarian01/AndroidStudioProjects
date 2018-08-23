package tk.httpcarabineer.stopwatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //1度だけ代入するものはvalを使う
    var handler = Handler()
    //繰り返し代入するためvarを使う
    var timeValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //View要素を変数に代入
        val time_text = findViewById(R.id.time_text) as TextView
        val start = findViewById(R.id.start) as Button
        val stop = findViewById(R.id.stop) as Button
        val reset = findViewById(R.id.reset) as Button

        //1秒ごとに処理を実行
        val runnable = object : Runnable {
            override fun run() {
                timeValue++

                timeToText(timeValue)?.let {
                    time_text.text = it
                }
                handler.postDelayed(this, 1000)
            }
        }

        // start
        start.setOnClickListener {
            handler.post(runnable)
        }

        // stop
        stop.setOnClickListener {
            handler.removeCallbacks(runnable)
        }

        // reset
        reset.setOnClickListener {
            handler.removeCallbacks(runnable)
            timeValue = 0
            // timeToTextの引数はデフォルト値が設定されているので、引数省略できる
            timeToText()?.let {
                time_text.text = it
            }
        }
    }
    // 数値を00:00:00形式の文字列に変換する関数
    // 引数timeにはデフォルト値0を設定、返却する型はnullableなString?型
    private fun timeToText(time: Int = 0): String? {
        return if (time < 0) {
            null
        } else if (time == 0) {
            "00:00:00"
        } else {
            val h = time / 3600
            val m = time % 3600 / 60
            val s = time % 60
            "%1$02d:%2$02d:%3$02d".format(h, m, s)
        }
    }
}
