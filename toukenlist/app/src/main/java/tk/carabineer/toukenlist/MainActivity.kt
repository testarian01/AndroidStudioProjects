package tk.carabineer.toukenlist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //        fun main(args: Array<String>) {
        // パースするJSON
//        val json = "{ \"bunrui\": \"短刀\", \"name\": \"三日月\", \"nameyomi\": \"アイゼンクニトシ\", \"bikou\": \"重要文化財、銘 国俊。法人蔵\", \"bunrui2\": \"短刀\", \"name2\": \"三日月2\", \"nameyomi2\": \"アイゼンクニトシ\", \"bikou2\": \"重要文化財、銘 国俊。法人蔵\" }"
        val json ="{ \"list01\": { \"bunrui\": \"短刀\", \"name\": \"三日月\", \"nameyomi\": \"アイゼンクニトシ\", \"bikou\": \"重要文化財、銘 国俊。法人蔵\" }, \"list02\": { \"bunrui\": \"短刀2\", \"name\": \"三日月2\", \"nameyomi\": \"アイゼンクニトシ2\", \"bikou\": \"重要文化財、銘 国俊。法人蔵2\" } }"

        // mapperオブジェクトを作成
        val mapper = jacksonObjectMapper()

        // jsonをdeserialize
        // 下の場合はjsonがColor型のオブジェクトにマッピングされる
        val toukenlist = mapper.readValue<Toukenlist>(json)

//        println(color)
//        println("名前：${name.kana}")
//        println("RGBAコードのG値：${color.code.rgba[1]}")

//            textview.setText("色(かな)：${color.kana}")


        // リストの項目となる文字列を配列で設定
        val items = arrayOf(toukenlist.list01.name, toukenlist.list02.name)

        // 配列から ArrayAdapter を作成
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)

        // レイアウトXMLから ListView を読み込み、リスト項目を設定
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = arrayAdapter


//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)


        listView.setOnItemClickListener { _, view, _, _ ->

            //インスタンス作成
            val intent = Intent(this, SecondActivity::class.java)
            //受け渡す変数
            val text = toukenlist.list01.name + toukenlist.list01.nameyomi
            //Inten変数をつなげる
            intent.putExtra("TEXT_KEY",text)
            //画面遷移を開始
            startActivity(intent)

//            val textView = view.findViewById<TextView>(android.R.id.text1)
//            Toast.makeText(this, "Clicked: ${textView.text}", Toast.LENGTH_SHORT).show()

        }

    }
}
