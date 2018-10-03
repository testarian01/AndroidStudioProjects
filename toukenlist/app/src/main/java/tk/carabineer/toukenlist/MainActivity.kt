package tk.carabineer.toukenlist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //        fun main(args: Array<String>) {
        // パースするJSON
//        val json ="{ \"list01\": { \"bunrui\": \"短刀\", \"name\": \"三日月\", \"nameyomi\": \"アイゼンクニトシ\", \"bikou\": \"重要文化財、銘 国俊。法人蔵\" }, \"list02\": { \"bunrui\": \"短刀2\", \"name\": \"三日月2\", \"nameyomi\": \"アイゼンクニトシ2\", \"bikou\": \"重要文化財、銘 国俊。法人蔵2\" } }"
        val json ="{ \"list01\": { \"bunrui\": \"短刀\", \"name\": \"愛染国俊\", \"nameyomi\": \"アイゼンクニトシ\", \"bikou\": \"重要文化財、銘 国俊。法人蔵。\" }, \"list02\": { \"bunrui\": \"短刀\", \"name\": \"会津新藤五\", \"nameyomi\": \"アイヅシントウゴ\", \"bikou\": \"国宝、銘 国光。ふくやま美術館寄託 小松コレクション。\" }, \"list03\": { \"bunrui\": \"打刀\", \"name\": \"会津正宗\", \"nameyomi\": \"アイヅマサムネ\", \"bikou\": \"御物、無銘 正宗。\" }, \"list04\": { \"bunrui\": \"打刀\", \"name\": \"青木兼元\", \"nameyomi\": \"アオキカネモト\", \"bikou\": \"銘 兼元。\" }, \"list05\": { \"bunrui\": \"太刀\", \"name\": \"明石国行\", \"nameyomi\": \"アカシクニユキ\", \"bikou\": \"国宝、銘 国行(来)。刀剣博物館蔵。\" }, \"list06\": { \"bunrui\": \"短刀\", \"name\": \"秋田藤四郎\", \"nameyomi\": \"アキタトウシロウ\", \"bikou\": \"重要文化財、銘 吉光。京都国立博物館蔵。\" }, \"list07\": { \"bunrui\": \"打刀\", \"name\": \"朝嵐\", \"nameyomi\": \"アサアラシ\", \"bikou\": \"重要美術品。末備前長船勝光による、松下某の注文打ち。\" }, \"list08\": { \"bunrui\": \"脇差\", \"name\": \"痣丸\", \"nameyomi\": \"アザマル\", \"bikou\": \"愛知県指定文化財、大磨上無銘。作者不明。熱田神宮蔵。\" }, \"list09\": { \"bunrui\": \"脇差\", \"name\": \"小豆長光\", \"nameyomi\": \"アズキナガミツ\", \"bikou\": \"上杉謙信が川中島の戦いにおいて武田信玄の軍配を切りつけたといわれる名刀。号は刃の上から小豆を落とすと真っ二つになったという伝説による。\" }, \"list10\": { \"bunrui\": \"打刀\", \"name\": \"安宅切\", \"nameyomi\": \"アタキギリ\", \"bikou\": \"銘 表 備前長船祐定 裏 大永二年八月日。金象嵌銘 あたき切脇毛落。現在は福岡市博物館蔵。拵は重要文化財。\" }, \"list11\": { \"bunrui\": \"短刀\", \"name\": \"厚藤四郎\", \"nameyomi\": \"アツシトウシロウ\", \"bikou\": \"国宝、銘 吉光。東京国立博物館蔵。\" }, \"list12\": { \"bunrui\": \"短刀\", \"name\": \"阿部包永\", \"nameyomi\": \"アベカネナガ\", \"bikou\": \"阿部正武が徳川綱吉より拝領した太刀。\" }, \"list13\": { \"bunrui\": \"短刀\", \"name\": \"新身来国光\", \"nameyomi\": \"アラミライクニミツ\", \"bikou\": \"重要文化財、銘来国光。\" } }"
        val mapper = jacksonObjectMapper()

        // jsonをdeserialize
        // 下の場合はjsonがColor型のオブジェクトにマッピングされる
        val toukenlist = mapper.readValue<Toukenlist>(json)

//        println(color)
//        println("名前：${name.kana}")
//        println("RGBAコードのG値：${color.code.rgba[1]}")

//            textview.setText("色(かな)：${color.kana}")


        // リストの項目となる文字列を配列で設定
//        val items = arrayOf(toukenlist.list01.name, toukenlist.list02.name)
        val items = arrayOf(toukenlist.list01.name, toukenlist.list02.name, toukenlist.list03.name, toukenlist.list04.name, toukenlist.list05.name, toukenlist.list06.name, toukenlist.list07.name, toukenlist.list08.name, toukenlist.list09.name, toukenlist.list10.name, toukenlist.list11.name, toukenlist.list12.name, toukenlist.list13.name)

        // 配列から ArrayAdapter を作成
        val arrayAdapter = ArrayAdapter<Any>(this, android.R.layout.simple_list_item_1, items)

        // レイアウトXMLから ListView を読み込み、リスト項目を設定
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = arrayAdapter


//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)


        listView.setOnItemClickListener { _, view, position, _ ->

            if(position==0){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list01.name
                val nameyomi = toukenlist.list01.nameyomi
                val bikou = toukenlist.list01.bikou

                //Inten変数をつなげる
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==1) {
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list02.name
                val nameyomi = toukenlist.list02.nameyomi
                val bikou = toukenlist.list02.bikou

                //Inten変数をつなげる
                intent.putExtra("name", name)
                intent.putExtra("nameyomi", nameyomi)
                intent.putExtra("bikou", bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==2) {
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list03.name
                val nameyomi = toukenlist.list03.nameyomi
                val bikou = toukenlist.list03.bikou

                //Inten変数をつなげる
                intent.putExtra("name", name)
                intent.putExtra("nameyomi", nameyomi)
                intent.putExtra("bikou", bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==3){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list04.name
                val nameyomi = toukenlist.list04.nameyomi
                val bikou = toukenlist.list04.bikou

                //Inten変数をつなげる
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==4){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list05.name
                val nameyomi = toukenlist.list05.nameyomi
                val bikou = toukenlist.list05.bikou

                //Inten変数をつなげる
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==5){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list06.name
                val nameyomi = toukenlist.list06.nameyomi
                val bikou = toukenlist.list06.bikou

                //Inten変数をつなげる
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==6){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list07.name
                val nameyomi = toukenlist.list07.nameyomi
                val bikou = toukenlist.list07.bikou

                //Inten変数をつなげる
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==7){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list08.name
                val nameyomi = toukenlist.list08.nameyomi
                val bikou = toukenlist.list08.bikou

                //Inten変数をつなげる
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==8){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list09.name
                val nameyomi = toukenlist.list09.nameyomi
                val bikou = toukenlist.list09.bikou

                //Inten変数をつなげる
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==9) {
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list10.name
                val nameyomi = toukenlist.list10.nameyomi
                val bikou = toukenlist.list10.bikou

                //Inten変数をつなげる
                intent.putExtra("name", name)
                intent.putExtra("nameyomi", nameyomi)
                intent.putExtra("bikou", bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==10){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list11.name
                val nameyomi = toukenlist.list11.nameyomi
                val bikou = toukenlist.list11.bikou

                //Inten変数をつなげる
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==11){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list12.name
                val nameyomi = toukenlist.list12.nameyomi
                val bikou = toukenlist.list12.bikou

                //Inten変数をつなげる
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)
            }else if(position==12){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val name = toukenlist.list13.name
                val nameyomi = toukenlist.list13.nameyomi
                val bikou = toukenlist.list13.bikou

                //Inten変数をつなげる
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)
            }
        }

    }
}
