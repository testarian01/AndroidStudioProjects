package tk.carabineer.toukenlist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class FirstActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        MobileAds.initialize(this, "ca-app-pub-5534482245506618~9002986464")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // パースするJSON
        val json = "{ \"list01\": { \"bunrui\": \"太刀\", \"touha\": \"三条\", \"name\": \"三日月宗近\", \"nameyomi\": \"みかづきむねちか\", \"bikou\": \"平安時代の刀工・三条宗近の作になる太刀。国宝。11世紀前後に制作されたとされ、「刀身に鎬と反りのある典型的な日本刀としては、もっとも古いものの一つである。「三日月」の号の由来は刀身に三日月形の打除け（うちのけ、刃文の一種）が数多くみられることによるものとされる。鎌倉時代末期から平安時代にかけてつくられた刀に多くみられる特徴として身幅（峰から刃までの幅）が鋒（切っ先）に向けて細くなっており、三日月宗近の場合は柄の部分と鋒の部分で2倍近い差がある。「天下五剣」の中でも最も美しいとも評される。\" }, \"list02\": { \"bunrui\": \"太刀\", \"touha\": \"三条\", \"name\": \"小狐丸\", \"nameyomi\": \"こぎつねまる\", \"bikou\": \"平安時代の刀工、三条宗近作といわれる太刀。能の「小鍛冶」に登場し、稲荷明神の援助によって作られたと伝わる。九条家が秘蔵していたとされるが、現在の所在は不明。朝廷から作刀を命ぜられたが満足のいく刀を打てずに困っていた三条宗近を助けるため、彼の氏神である稲荷明神が童子に化けて相槌を打ったといわれる。 また、謡曲『小鍛冶』にてモチーフにされている刀は小狐丸である。\" }, \"list03\": { \"bunrui\": \"大太刀\", \"touha\": \"三条\", \"name\": \"石切丸\", \"nameyomi\": \"いしきりまる\", \"bikou\": \"平安時代の刀工、三条宗近作とされる。大阪府東大阪市の石切劔箭神社（いしきりつるぎやじんじゃ）に伝わる宝刀。石切剣箭神社は神道石切教の神社で、「石切さん」「でんぼ（腫れ物）の神様」として親しまれ、本殿前と神社入り口にある百度石の間を行き来するお百度参りが全国的に有名。\" }, \"list04\": { \"bunrui\": \"薙刀\", \"touha\": \"三条\", \"name\": \"岩融\", \"nameyomi\": \"いわとおし\", \"bikou\": \"平安時代の刀工、三条宗近作とされる。武蔵坊弁慶が使っていたことで有名。刃の部分だけでも1mもあったとされている（当時の薙刀の標準的な刃の大きさは80cm）。岩融の名の由来は不詳。『義経記』の中には弁慶所持の「岩透（いわとおし）」なる刀（太刀）が登場するが、両者の関係性も不明。\" }, \"list05\": { \"bunrui\": \"短刀\", \"touha\": \"三条\", \"name\": \"今剣\", \"nameyomi\": \"いまのつるぎ\", \"bikou\": \"平安時代の刀工、三条宗近作とされる。宗近により鞍馬寺に奉納された後に、源義経の守り刀となったとされるが、唯一の登場作品「義経記」が後世の創作によるものなので、実在するかは不明。 「義経記」によると、義経の自刃の際に使われたと言われているが、事実だったのかは不明である。\" }, \"list06\": { \"bunrui\": \"太刀\", \"touha\": \"三池\", \"name\": \"大典太光世\", \"nameyomi\": \"おおでんたみつよ\", \"bikou\": \"天下五剣のひとつで、三池典太光世作の太刀。同時代の刀剣とは作風が隔絶しており、その異質さからか枕元に置けば病も治るとされた霊刀。三日月宗近と並ぶ足利将軍家の宝刀で、将軍家の没落により豊臣秀吉に献上され、さらに秀吉が前田利家に与え、以後は前田家の家宝となった。\" }, \"list07\": { \"bunrui\": \"太刀\", \"touha\": \"三池\", \"name\": \"ソハヤノツルキ\", \"nameyomi\": \"そはやのつるぎ\", \"bikou\": \"無銘であるが、三池典太光世作と伝わる太刀。坂上田村麻呂の佩刀であった「ソハヤの剣」（坂上宝剣）の写し。徳川家康が所持し、死後霊刀として一緒に葬られたと言われている。\" }, \"list08\": { \"bunrui\": \"太刀\", \"touha\": \"青江\", \"name\": \"数珠丸恒次\", \"nameyomi\": \"じゅずまるつねつぐ\", \"bikou\": \"天下五剣のひとつで、青江恒次作との説がある太刀。ただし、その特徴は古青江派とは逸する部分が多く、現在は鎌倉初期に活躍した備前恒次(びぜんつねつぐ)の作ではないか、とも目されている。後に天下五剣に数えられた。法華宗(日蓮宗)の開祖・日蓮上人の「三遺品」に数えられ、甲斐国身延山久遠寺が所蔵していたが、故あって現在は兵庫県尼崎市の本興寺が所蔵している。\" }, \"list09\": { \"bunrui\": \"脇差\", \"touha\": \"青江\", \"name\": \"にっかり青江\", \"nameyomi\": \"にっかりあおえ\", \"bikou\": \"備中青江派の大脇差。大太刀が磨上げられて今の姿になっている。実体のない女の幽霊すら斬ると伝説が残る名刀。女の幽霊を切った人物についても諸説あるがその後刀は柴田勝家に所有が移り、子の柴田勝敏に譲られた。さらに柴田勝敏を討った丹羽長秀から豊臣秀吉に献上され、子の豊臣秀頼から京極高次に与えられ以降京極家に秘蔵される。江戸時代の狂歌に京極家について歌ったものがありそのなかで 『京極にすぎたるものが三つある。ニッカリ茶壺に多賀越中』とにっかり青江の名もあがっており、当時から名品として有名だったことが伺える。 \" }, \"list10\": { \"bunrui\": \"打刀\", \"touha\": \"粟田口\", \"name\": \"鳴狐\", \"nameyomi\": \"なきぎつね\", \"bikou\": \"粟田口国吉作の打刀。鎌倉時代のものとして打刀は珍しく、差表に銘が掘られているのが特徴。鳴狐という名前の由来は不明だが、出羽国山形藩の秋元家に伝来していた。「刀 銘左兵衛尉藤原国吉」の名称で、重要文化財に指定されている。\" }, \"list11\": { \"bunrui\": \"太刀\", \"touha\": \"粟田口\", \"name\": \"一期一振\", \"nameyomi\": \"いちごひとふり\", \"bikou\": \"短刀作りの名手として知られる粟田口吉光の太刀。粟田口吉光は正宗と並ぶ名工とされるが、その作品は短刀ばかりで太刀は数えるほどしか作られず、その中でも素晴らしい出来とされ、「一期一振」と呼ばれた。 戦国時代、朝倉氏が所有していたが、朝倉氏滅亡後は毛利氏の物となり、毛利輝元より豊臣秀吉に献上された。小柄な体格であった秀吉は、自分の体格に合わせて、刃長が2尺8寸3分（約86cm）あった一期一振を、2尺2寸7分（約69cm）に磨上げた。秀吉の死後も豊臣氏に伝えられていたが、豊臣氏滅亡後は徳川家に伝わる。その後、大阪夏の陣もしくは明暦の大火により一期一振は焼身となるも、徳川家は越前康継（年代的に二代目、もしくは三代目）に打ち直させた。こうして蘇った一期一振は尾張徳川家に伝えられた。幕末に至り、文久3年（1863年）、尾張藩主・徳川茂徳より孝明天皇に献上された。以後、皇室に伝えられ、皇室御物となっている。\" }, \"list12\": { \"bunrui\": \"脇差\", \"touha\": \"粟田口\", \"name\": \"鯰尾藤四郎\", \"nameyomi\": \"なまずおとうしろう\", \"bikou\": \"鎌倉時代に活躍した刀工 粟田口吉光作の脇差。由来は、鯰の尾を連想させる”ふくら”がふっくらした姿から「鯰尾」の異名を持つ。元は小薙刀であったが、大坂夏の陣で焼身となる。初代越前康継によって磨り上げられ、脇差としてその姿を今に残す。 \" }, \"list13\": { \"bunrui\": \"脇差\", \"touha\": \"粟田口\", \"name\": \"骨喰藤四郎\", \"nameyomi\": \"ほねばみとうしろう\", \"bikou\": \"薙刀を磨り上げて寸を詰めた、薙刀直しの脇差。鎌倉時代中期の刀工・粟田口吉光の作。号の由来は、『斬る真似をしただけで骨が砕ける』とされたこと。大阪夏の陣の大阪城落城の際、奇跡的に堀の中から無傷で回収されたが、1657年の明暦の大火で焼身となる。その後修復され、現在は重要文化財に指定されている。\" }, \"list14\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"平野藤四郎\", \"nameyomi\": \"ひらのとうしろう\", \"bikou\": \"鎌倉時代中期の刀工、粟田口吉光の作の短刀。刃長は短刀としては長く、一尺(30.3cm)にも及ぶ。木村重茲が摂津の商人・平野道雪より金三十枚で買い求めた事から、この名で呼ばれるようになった。前田家と徳川家の間を一往復した(重茲から豊臣秀吉へ献上され、前田利長が拝領。この利長から徳川秀忠へ献上され、再度、前田利光が拝領した)。\" }, \"list15\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"厚藤四郎\", \"nameyomi\": \"あつしとうしろう\", \"bikou\": \"室町時代から名物として名高く、寸法が短く極めて小ぶりであるが、刀身が極端に厚いことから「厚藤四郎」と呼ばれた。 読みについては、「あつとうしろう」「あつしとうしろう」の両方がある。埋忠押型には仮名で「安徒（あつ）藤四郎」となっている。なお、この刀のように身幅が狭く重ねが極端に厚い、頑丈な造り込みの短刀は「鎧通し」と呼ばれる。\" }, \"list16\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"後藤藤四郎\", \"nameyomi\": \"ごとうとうしろう\", \"bikou\": \"鎌倉時代中期の刀工、京の粟田口藤四郎吉光作の短刀。江戸幕府の御金改役（金座の元締）であった後藤庄三郎光次が所持していたことが名前の由来。平造、三つ棟、内反、やや大振りの短刀で目釘孔下に「吉光」の二字銘が入っている。\" }, \"list17\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"信濃藤四郎\", \"nameyomi\": \"しなのとうしろう\", \"bikou\": \"鎌倉時代中期の刀鍛冶で短刀作りの名手と呼ばれた粟田口吉光により作られた短刀である。元々は秀吉が所持していたもので、後に関ヶ原合戦にも参加したことのある徳川家康の家臣で元老中・永井信濃守尚政に渡ったことが名の由来。その後、徳川将軍家へ献上された。\" }, \"list18\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"前田藤四郎\", \"nameyomi\": \"まえだとうしろう\", \"bikou\": \"鎌倉時代中期の刀鍛冶で短刀作りの名手と呼ばれた粟田口義光により作られた短刀である。加賀前田家の前田孫四郎利政が所持していたためこの名がついた。\" }, \"list19\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"秋田藤四郎\", \"nameyomi\": \"あきたとうしろう\", \"bikou\": \"鎌倉時代の刀工・粟田口藤四郎吉光の打った短刀。豊臣秀吉に仕えた秋田実季の所持であったことからこの名で呼ばれる。刀身の表に梵字と素剣、裏に護摩箸の彫物がある。\" }, \"list20\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"博多藤四郎\", \"nameyomi\": \"はかたとうしろう\", \"bikou\": \"鎌倉時代の刀工・粟田口藤四郎吉光の打った短刀。「博多藤四郎」の号は黒田忠之が小倉表の海上で、小笠原忠真にこの短刀を贈った事が由来となっており、黒田領地である博多から出てきた道具のため、博多藤四郎と呼ばれるようになった。\" }, \"list21\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"乱藤四郎\", \"nameyomi\": \"みだれとうしろう\", \"bikou\": \"鎌倉時代の刀工・粟田口藤四郎吉光の打った短刀。藤四郎としては珍しく乱れ刃を持ち、これが号の由来ともなっている。室町時代、細川勝元の所持となっていた時に名付けられたとされる。江戸時代には忍藩・白河藩藩主を歴任した阿部家に伝来。\" }, \"list22\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"五虎退\", \"nameyomi\": \"ごこたい\", \"bikou\": \"鎌倉時代の刀工・粟田口藤四郎吉光の打った短刀。上杉謙信が上洛した際に正親町天皇より拝領。足利義満の遣明使として明に向かった役人が五頭の虎に襲われた時この短刀で追い払ったといういわれがある。\" }, \"list23\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"薬研藤四郎\", \"nameyomi\": \"やげんとうしろう\", \"bikou\": \"鎌倉時代の刀工・粟田口藤四郎吉光の打った短刀。名前の由来は室町期の武将・畠山政長がこの刀で切腹しようとしたが、何度試しても腹に刺さらず、政長が苛立って投げつけると、そこにあった薬研を見事に貫いたことによる。その後、足利将軍家に伝来。しかし十三代将軍・足利義輝が殺された折に、松永久秀に奪われる。 久秀は織田信長にこの刀を献上し、これを気に入った信長は愛刀として常に肌身離さず所持し、本能寺の変で横死するまで傍に置いたという。本能寺の変に於いて薬研藤四郎は焼失したとされるのが一般的な説であるが、異説ではその後豊臣秀吉の手に渡ったとも、更に徳川将軍家に伝えられたともある。「享保名物帳」には焼身として名を記載されているが、現在、その所在は解らない。\" }, \"list24\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"包丁藤四郎\", \"nameyomi\": \"ほうちょうとうしろう\", \"bikou\": \"「ホウチョウトウシロウ」と同じ読みをする刀は二振りある。どちらも徳川家に関係する刀であるが、記録によると明らかに長さが違うため、別刀だと考えられている。また、一方は美術館で保存されているが、もう一方は明暦の大火で焼失してしまっている。\" }, \"list25\": { \"bunrui\": \"太刀\", \"touha\": \"古備前\", \"name\": \"大包平\", \"nameyomi\": \"おおかねひら\", \"bikou\": \"12世紀頃、備前三平がひとり備前国の包平によって作刀されたといわれる。古備前派。包平の刀は通常「包平」と二文字で銘が切られているがこの刀は「備前国包平作」と長い銘がきられている。刃長は実測で89.2cm。幅が広く、反りが高く、大きさの割に非常に軽い。日本一との誉れも高き日本刀であり、童子切安綱と並んで日本刀の東西両横綱と称される程の刀で「日本刀の最高傑作」として知られている。\" }, \"list26\": { \"bunrui\": \"太刀\", \"touha\": \"古備前\", \"name\": \"鶯丸\", \"nameyomi\": \"うぐいすまる\", \"bikou\": \"平安時代中頃に興った備前国の日本刀刀工一派、古備前派の備前国友成による太刀。現存する友成の作った刀の中で最も古いものの一つである。皇室に伝来した所蔵品である「御物」であり、現在は宮内庁が管理している。御物であるため、慣例的に国宝や重要文化財などの指定は受けていない。「鶯丸」と言う名前の由来については不明だが、室町時代には既にこの呼称だったという。 \" }, \"list27\": { \"bunrui\": \"太刀\", \"touha\": \"来\", \"name\": \"明石国行\", \"nameyomi\": \"あかしくにゆき\", \"bikou\": \"来派の祖である来国行の作で、国宝に指定されている。播磨国明石松平家伝来のため「明石国行」の号を持つ。身幅広く、腰反り高く、中切先の鎌倉時代中期特有の体配であるが、国行の作中ではやや細身に属する。地鉄は小板目つみ、やや肌立ち、刃文は広直刃調に丁子を交え、刃中の働きが盛んなものである。茎は生ぶで雉股形となり、茎尻に手抜き緒通しの孔があり、貴重である。\" }, \"list28\": { \"bunrui\": \"大太刀\", \"touha\": \"来\", \"name\": \"蛍丸\", \"nameyomi\": \"ほたるまる\", \"bikou\": \"来国俊によって作られた大太刀。南北朝時代の武将・阿蘇惟澄が実戦で使用した際に、刃こぼれした刀に蛍が集まって直ったという夢を見て、目が覚めたら本当に刀が治っていた……という逸話から名づけられている。国宝指定され阿蘇神社に保管されていたが、太平洋戦争の戦火に巻き込まれ、現在は行方不明となっている。\" }, \"list29\": { \"bunrui\": \"短刀\", \"touha\": \"来\", \"name\": \"愛染国俊\", \"nameyomi\": \"あいぜんくにとし\", \"bikou\": \"鎌倉時代・後期に京都で活躍した来派の刀工、国俊（二字国俊）が打った刀。「国俊」と二字に切られた銘を持つ。名前は茎の表に仏教の愛染明王が彫られていることに由来する。元々、豊臣秀吉が所蔵していたが、その後徳川家康の手に渡り、元和2年（1616年）大坂の陣で戦功のあった森忠政（森蘭丸の弟・千丸）に下賜された。忠政の死後、遺物として3代将軍・徳川家光に献上され、後に前田家へ贈り物とされた。現在は重要文化財に指定されている。 \" }, \"list30\": { \"bunrui\": \"打刀\", \"touha\": \"村正\", \"name\": \"千子村正\", \"nameyomi\": \"せんごむらまさ\", \"bikou\": \"初代村正（千子村正）の作で、恐ろしいほどの切れ味を持つ実戦向きの打刀。史上最も有名な刀工名の一つ。その作は武器としての日本刀の代名詞で、斬味凄絶無比と名高く、精強で知られる三河武士を中心に、将軍徳川家康・関白豊臣秀次ら天下人を含む戦国時代の武将から至上の業物（実戦刀）として愛用された。\" } }"
        val mapper = jacksonObjectMapper()

        // jsonをdeserialize
        // 下の場合はjsonがColor型のオブジェクトにマッピングされる
        val toukenlist = mapper.readValue<Toukenlist>(json)

        // リストの項目となる文字列を配列で設定
        val items = arrayOf(toukenlist.list01.name, toukenlist.list02.name, toukenlist.list03.name, toukenlist.list04.name, toukenlist.list05.name, toukenlist.list06.name, toukenlist.list07.name, toukenlist.list08.name, toukenlist.list09.name, toukenlist.list10.name, toukenlist.list11.name, toukenlist.list12.name, toukenlist.list13.name, toukenlist.list14.name, toukenlist.list15.name, toukenlist.list16.name, toukenlist.list17.name, toukenlist.list18.name, toukenlist.list19.name, toukenlist.list20.name, toukenlist.list21.name, toukenlist.list22.name, toukenlist.list23.name, toukenlist.list24.name, toukenlist.list25.name, toukenlist.list26.name, toukenlist.list27.name, toukenlist.list28.name, toukenlist.list29.name, toukenlist.list30.name)

        // 配列から ArrayAdapter を作成
//        val arrayAdapter = ArrayAdapter<Any>(this, android.R.layout.simple_list_item_1, items)
        val arrayAdapter = ArrayAdapter(this, R.layout.list, items)

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

            }else if(position==13){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list14.bunrui
                val touha = toukenlist.list14.touha
                val name = toukenlist.list14.name
                val nameyomi = toukenlist.list14.nameyomi
                val bikou = toukenlist.list14.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==14){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list15.bunrui
                val touha = toukenlist.list15.touha
                val name = toukenlist.list15.name
                val nameyomi = toukenlist.list15.nameyomi
                val bikou = toukenlist.list15.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==15){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list16.bunrui
                val touha = toukenlist.list16.touha
                val name = toukenlist.list16.name
                val nameyomi = toukenlist.list16.nameyomi
                val bikou = toukenlist.list16.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==16){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list17.bunrui
                val touha = toukenlist.list17.touha
                val name = toukenlist.list17.name
                val nameyomi = toukenlist.list17.nameyomi
                val bikou = toukenlist.list17.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==17){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list18.bunrui
                val touha = toukenlist.list18.touha
                val name = toukenlist.list18.name
                val nameyomi = toukenlist.list18.nameyomi
                val bikou = toukenlist.list18.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==18){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list19.bunrui
                val touha = toukenlist.list19.touha
                val name = toukenlist.list19.name
                val nameyomi = toukenlist.list19.nameyomi
                val bikou = toukenlist.list19.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==19){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list20.bunrui
                val touha = toukenlist.list20.touha
                val name = toukenlist.list20.name
                val nameyomi = toukenlist.list20.nameyomi
                val bikou = toukenlist.list20.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==20){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list21.bunrui
                val touha = toukenlist.list21.touha
                val name = toukenlist.list21.name
                val nameyomi = toukenlist.list21.nameyomi
                val bikou = toukenlist.list21.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==21){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list22.bunrui
                val touha = toukenlist.list22.touha
                val name = toukenlist.list22.name
                val nameyomi = toukenlist.list22.nameyomi
                val bikou = toukenlist.list22.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==22){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list23.bunrui
                val touha = toukenlist.list23.touha
                val name = toukenlist.list23.name
                val nameyomi = toukenlist.list23.nameyomi
                val bikou = toukenlist.list23.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==23){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list24.bunrui
                val touha = toukenlist.list24.touha
                val name = toukenlist.list24.name
                val nameyomi = toukenlist.list24.nameyomi
                val bikou = toukenlist.list24.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==24){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list25.bunrui
                val touha = toukenlist.list25.touha
                val name = toukenlist.list25.name
                val nameyomi = toukenlist.list25.nameyomi
                val bikou = toukenlist.list25.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==25){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list26.bunrui
                val touha = toukenlist.list26.touha
                val name = toukenlist.list26.name
                val nameyomi = toukenlist.list26.nameyomi
                val bikou = toukenlist.list26.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==26){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list27.bunrui
                val touha = toukenlist.list27.touha
                val name = toukenlist.list27.name
                val nameyomi = toukenlist.list27.nameyomi
                val bikou = toukenlist.list27.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==27){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list28.bunrui
                val touha = toukenlist.list28.touha
                val name = toukenlist.list28.name
                val nameyomi = toukenlist.list28.nameyomi
                val bikou = toukenlist.list28.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==28){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list29.bunrui
                val touha = toukenlist.list29.touha
                val name = toukenlist.list29.name
                val nameyomi = toukenlist.list29.nameyomi
                val bikou = toukenlist.list29.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==29){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list30.bunrui
                val touha = toukenlist.list30.touha
                val name = toukenlist.list30.name
                val nameyomi = toukenlist.list30.nameyomi
                val bikou = toukenlist.list30.bikou

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
