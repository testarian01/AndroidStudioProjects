package tk.httpcarabineer.yarumemo

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton

import android.view.View
import android.support.v7.app.AlertDialog
import android.widget.*

import android.icu.text.SimpleDateFormat
import java.util.*
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ArrayAdapter を作成
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
//        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1).apply {
//            add("Android")
//            add("iOS")
//            add("Windows")
//            add("macOS")
//            add("Unix")
//        }

        // レイアウトXMLから ListView を読み込み、リスト項目を設定
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = arrayAdapter

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton

        // FABが押された時に処理
        fab.setOnClickListener {

            val edit = EditText(this)
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("文字を入力してください")
            dialog.setView(edit)
            dialog.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                // OKボタン押したときの処理
                val userText = edit.getText().toString()

//                // 現在日時の取得
//                val now = Date(System.currentTimeMillis())
//                // 日時のフォーマットオブジェクト作成
//                val formatter = SimpleDateFormat("yyyy年MM月dd日 HH時mm分")
//                // フォーマット
//                val nowText = formatter.format(now)
//
//                val ed_text = nowText + "\n" + userText

                val ed_text = userText

                //追加
                //arrayAdapter.insert(nowText + /n + userText, arrayAdapter.count)
                arrayAdapter.insert(ed_text, arrayAdapter.count)
            })
            dialog.setNegativeButton("キャンセル", null)
            dialog.show()

        }

        //項目をタップしたときの処理
        //listView.setOnItemClickListener { parent, view, position, id ->
        listView.setOnItemClickListener { _, _, position, _ ->

            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("削除しますか？")
            dialog.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                //削除
                arrayAdapter.remove(arrayAdapter.getItem(position))
                arrayAdapter.notifyDataSetChanged()
                //return@setOnItemLongClickListener true
            })
            dialog.setNegativeButton("キャンセル", null)
            dialog.show()

        }
    }
}
