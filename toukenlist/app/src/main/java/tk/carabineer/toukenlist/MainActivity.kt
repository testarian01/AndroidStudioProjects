package tk.carabineer.toukenlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //        fun main(args: Array<String>) {
        // パースするJSON
//        val json = "{ \"bunrui\": \"短刀\", \"name\": \"三日月\", \"nameyomi\": \"アイゼンクニトシ\", \"bikou\": \"重要文化財、銘 国俊。法人蔵\", \"bunrui2\": \"短刀\", \"name2\": \"三日月2\", \"nameyomi2\": \"アイゼンクニトシ\", \"bikou2\": \"重要文化財、銘 国俊。法人蔵\" }"
        val json ="{ \"code\": { \"bunrui\": \"短刀\", \"name\": \"三日月\", \"nameyomi\": \"アイゼンクニトシ\", \"bikou\": \"重要文化財、銘 国俊。法人蔵\" }, \"code\": { \"bunrui\": \"短刀2\", \"name\": \"三日月2\", \"nameyomi\": \"アイゼンクニトシ2\", \"bikou\": \"重要文化財、銘 国俊。法人蔵2\" } }"

        // mapperオブジェクトを作成
        val mapper = jacksonObjectMapper()

        // jsonをdeserialize
        // 下の場合はjsonがColor型のオブジェクトにマッピングされる
//        val color = mapper.readValue<Color>(json)
        val toukenlist = mapper.readValue<Toukenlist>(json)

//        println(color)
//        println("名前：${name.kana}")
//        println("RGBAコードのG値：${color.code.rgba[1]}")

//            textview.setText("色(かな)：${color.kana}")


        // リストの項目となる文字列を配列で設定
        val items = arrayOf("名前：${toukenlist.code.name}")

//        val items = arrayOf("テスト","テストだよ")


        // 配列から ArrayAdapter を作成
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)


        // レイアウトXMLから ListView を読み込み、リスト項目を設定
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = arrayAdapter




    }


}
