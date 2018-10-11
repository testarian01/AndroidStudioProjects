package tk.carabineer.toukenlist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        // パースするJSON
        val json ="{ \"list01\": { \"bunrui\": \"太刀\", \"touha\": \"三条\", \"name\": \"三日月宗近\", \"nameyomi\": \"みかづきむねちか\", \"bikou\": \"平安時代の刀工、三条宗近作の太刀。天下五剣のひとつで、その中でも最も美しいと評される。\" }, \"list02\": { \"bunrui\": \"太刀\", \"touha\": \"三条\", \"name\": \"小狐丸\", \"nameyomi\": \"こぎつねまる\", \"bikou\": \"平安時代の刀工、三条宗近作といわれる太刀。能の「小鍛冶」に登場し、稲荷明神の援助によって作られたと伝わる。\" }, \"list03\": { \"bunrui\": \"大太刀\", \"touha\": \"三条\", \"name\": \"石切丸\", \"nameyomi\": \"いしきりまる\", \"bikou\": \"石切劔箭神社に伝わる宝刀「石切丸」が有名だが、「石切」という名の刀は複数の逸話が存在する。いずれも詳細は不明。同一の刀の逸話であるのかすらはっきりしない。\" }, \"list04\": { \"bunrui\": \"薙刀\", \"touha\": \"三条\", \"name\": \"岩融\", \"nameyomi\": \"いわとおし\", \"bikou\": \"武蔵坊弁慶が振るっていたとされる薙刀。現存しておらず、実在したかどうかも不明な伝承の大薙刀。伝承によれば、刃の部分だけでも三尺五寸（約1.06m）あったとされる。\" }, \"list05\": { \"bunrui\": \"短刀\", \"touha\": \"三条\", \"name\": \"今剣\", \"nameyomi\": \"いまのつるぎ\", \"bikou\": \"源義経の守り刀であり自刃した短刀として有名だが、実物は不明。作者は伝説の名工、三条宗近。\" }, \"list06\": { \"bunrui\": \"太刀\", \"touha\": \"三池\", \"name\": \"大典太光世\", \"nameyomi\": \"おおでんたみつよ\", \"bikou\": \"天下五剣のひとつで、三池典太光世作の太刀。同時代の刀剣とは作風が隔絶しており、その異質さからか枕元に置けば病も治るとされた霊刀。\" }, \"list07\": { \"bunrui\": \"太刀\", \"touha\": \"三池\", \"name\": \"ソハヤノツルキ\", \"nameyomi\": \"ソハヤノツルキ\", \"bikou\": \"無銘であるが、三池典太光世作と伝わる太刀。坂上田村麻呂の佩刀であった「ソハヤの剣」（坂上宝剣）の写し。徳川家康が所持し、死後霊刀として一緒に葬られたと言われている。\" }, \"list08\": { \"bunrui\": \"太刀\", \"touha\": \"青江\", \"name\": \"数珠丸恒次\", \"nameyomi\": \"じゅずまるつねつぐ\", \"bikou\": \"天下五剣のひとつで、青江恒次作との説がある太刀。鎌倉時代の僧、日蓮が護身用として所持していたと伝わり、柄に数珠が巻かれていたことが名の由来ともされている。\" }, \"list09\": { \"bunrui\": \"脇差\", \"touha\": \"青江\", \"name\": \"にっかり青江\", \"nameyomi\": \"にっかりあおえ\", \"bikou\": \"備中青江派の大脇差。実体のない幽霊すら斬ると伝説が残る名刀。\" }, \"list10\": { \"bunrui\": \"打刀\", \"touha\": \"粟田口\", \"name\": \"鳴狐\", \"nameyomi\": \"なきぎつね\", \"bikou\": \"粟田口国吉作の打刀。鎌倉時代に作られ、打刀と称していたものと思われる珍しい作品。\" }, \"list11\": { \"bunrui\": \"太刀\", \"touha\": \"粟田口\", \"name\": \"一期一振\", \"nameyomi\": \"いちごひとふり\", \"bikou\": \"短刀作りの名手として知られる粟田口吉光の太刀。名は一生に一振りしか作らなかったという意味を有している。\" }, \"list12\": { \"bunrui\": \"脇差\", \"touha\": \"粟田口\", \"name\": \"鯰尾藤四郎\", \"nameyomi\": \"なまずおとうしろう\", \"bikou\": \"鎌倉時代に活躍した刀工 粟田口吉光作の脇差。元は小薙刀だったが脇差へと磨上げられた。\" }, \"list13\": { \"bunrui\": \"脇差\", \"touha\": \"粟田口\", \"name\": \"骨喰藤四郎\", \"nameyomi\": \"ほねばみとうしろう\", \"bikou\": \"鎌倉時代に活躍した刀工 粟田口吉光作の脇差。元は薙刀だったが脇差へと磨上げられた。\" } }"
        val mapper = jacksonObjectMapper()

        // jsonをdeserialize
        // 下の場合はjsonがColor型のオブジェクトにマッピングされる
        val toukenlist = mapper.readValue<Toukenlist>(json)

        // リストの項目となる文字列を配列で設定
        val items = arrayOf(toukenlist.list01.name, toukenlist.list02.name, toukenlist.list03.name, toukenlist.list04.name, toukenlist.list05.name, toukenlist.list06.name, toukenlist.list07.name, toukenlist.list08.name, toukenlist.list09.name, toukenlist.list10.name, toukenlist.list11.name, toukenlist.list12.name, toukenlist.list13.name)

        // 配列から ArrayAdapter を作成
        val arrayAdapter = ArrayAdapter<Any>(this, android.R.layout.simple_list_item_1, items)

        // レイアウトXMLから ListView を読み込み、リスト項目を設定
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { _, view, position, _ ->

            if(position==0){
                //インスタンス作成
                val intent = Intent(this, SecondActivity::class.java)

                //受け渡す変数
                val bunrui = toukenlist.list01.bunrui
                val touha = toukenlist.list01.touha
                val name = toukenlist.list01.name
                val nameyomi = toukenlist.list01.nameyomi
                val bikou = toukenlist.list01.bikou

                //Inten変数をつなげる
                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                //画面遷移を開始
                startActivity(intent)

            }else if(position==1) {
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list02.bunrui
                val touha = toukenlist.list02.touha
                val name = toukenlist.list02.name
                val nameyomi = toukenlist.list02.nameyomi
                val bikou = toukenlist.list02.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==2) {
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list03.bunrui
                val touha = toukenlist.list03.touha
                val name = toukenlist.list03.name
                val nameyomi = toukenlist.list03.nameyomi
                val bikou = toukenlist.list03.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name", name)
                intent.putExtra("nameyomi", nameyomi)
                intent.putExtra("bikou", bikou)

                startActivity(intent)

            }else if(position==3){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list04.bunrui
                val touha = toukenlist.list04.touha
                val name = toukenlist.list04.name
                val nameyomi = toukenlist.list04.nameyomi
                val bikou = toukenlist.list04.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==4){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list05.bunrui
                val touha = toukenlist.list05.touha
                val name = toukenlist.list05.name
                val nameyomi = toukenlist.list05.nameyomi
                val bikou = toukenlist.list05.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==5){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list06.bunrui
                val touha = toukenlist.list06.touha
                val name = toukenlist.list06.name
                val nameyomi = toukenlist.list06.nameyomi
                val bikou = toukenlist.list06.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==6){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list07.bunrui
                val touha = toukenlist.list07.touha
                val name = toukenlist.list07.name
                val nameyomi = toukenlist.list07.nameyomi
                val bikou = toukenlist.list07.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==7){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list08.bunrui
                val touha = toukenlist.list08.touha
                val name = toukenlist.list08.name
                val nameyomi = toukenlist.list08.nameyomi
                val bikou = toukenlist.list08.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==8){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list09.bunrui
                val touha = toukenlist.list09.touha
                val name = toukenlist.list09.name
                val nameyomi = toukenlist.list09.nameyomi
                val bikou = toukenlist.list09.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==9) {
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list10.bunrui
                val touha = toukenlist.list10.touha
                val name = toukenlist.list10.name
                val nameyomi = toukenlist.list10.nameyomi
                val bikou = toukenlist.list10.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name", name)
                intent.putExtra("nameyomi", nameyomi)
                intent.putExtra("bikou", bikou)

                startActivity(intent)

            }else if(position==10){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list11.bunrui
                val touha = toukenlist.list11.touha
                val name = toukenlist.list11.name
                val nameyomi = toukenlist.list11.nameyomi
                val bikou = toukenlist.list11.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)
            }else if(position==11){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list12.bunrui
                val touha = toukenlist.list12.touha
                val name = toukenlist.list12.name
                val nameyomi = toukenlist.list12.nameyomi
                val bikou = toukenlist.list12.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==12){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list13.bunrui
                val touha = toukenlist.list13.touha
                val name = toukenlist.list13.name
                val nameyomi = toukenlist.list13.nameyomi
                val bikou = toukenlist.list13.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }
        }

    }
}
