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
        val json = "{ \"list01\": { \"bunrui\": \"太刀\", \"touha\": \"三条\", \"name\": \"三日月宗近\", \"nameyomi\": \"みかづきむねちか\", \"bikou\": \"平安時代の刀工・三条宗近の作になる太刀。国宝。11世紀前後に制作されたとされ、「刀身に鎬と反りのある典型的な日本刀としては、もっとも古いものの一つである。「三日月」の号の由来は刀身に三日月形の打除け（うちのけ、刃文の一種）が数多くみられることによるものとされる。鎌倉時代末期から平安時代にかけてつくられた刀に多くみられる特徴として身幅（峰から刃までの幅）が鋒（切っ先）に向けて細くなっており、三日月宗近の場合は柄の部分と鋒の部分で2倍近い差がある。「天下五剣」の中でも最も美しいとも評される。\" }, \"list02\": { \"bunrui\": \"太刀\", \"touha\": \"三条\", \"name\": \"小狐丸\", \"nameyomi\": \"こぎつねまる\", \"bikou\": \"平安時代の刀工、三条宗近作といわれる太刀。能の「小鍛冶」に登場し、稲荷明神の援助によって作られたと伝わる。九条家が秘蔵していたとされるが、現在の所在は不明。朝廷から作刀を命ぜられたが満足のいく刀を打てずに困っていた三条宗近を助けるため、彼の氏神である稲荷明神が童子に化けて相槌を打ったといわれる。 また、謡曲『小鍛冶』にてモチーフにされている刀は小狐丸である。\" }, \"list03\": { \"bunrui\": \"大太刀\", \"touha\": \"三条\", \"name\": \"石切丸\", \"nameyomi\": \"いしきりまる\", \"bikou\": \"平安時代の刀工、三条宗近作とされる。大阪府東大阪市の石切劔箭神社（いしきりつるぎやじんじゃ）に伝わる宝刀。石切剣箭神社は神道石切教の神社で、「石切さん」「でんぼ（腫れ物）の神様」として親しまれ、本殿前と神社入り口にある百度石の間を行き来するお百度参りが全国的に有名。\" }, \"list04\": { \"bunrui\": \"薙刀\", \"touha\": \"三条\", \"name\": \"岩融\", \"nameyomi\": \"いわとおし\", \"bikou\": \"平安時代の刀工、三条宗近作とされる。武蔵坊弁慶が使っていたことで有名。刃の部分だけでも1mもあったとされている（当時の薙刀の標準的な刃の大きさは80cm）。岩融の名の由来は不詳。『義経記』の中には弁慶所持の「岩透（いわとおし）」なる刀（太刀）が登場するが、両者の関係性も不明。\" }, \"list05\": { \"bunrui\": \"短刀\", \"touha\": \"三条\", \"name\": \"今剣\", \"nameyomi\": \"いまのつるぎ\", \"bikou\": \"平安時代の刀工、三条宗近作とされる。宗近により鞍馬寺に奉納された後に、源義経の守り刀となったとされるが、唯一の登場作品「義経記」が後世の創作によるものなので、実在するかは不明。 「義経記」によると、義経の自刃の際に使われたと言われているが、事実だったのかは不明である。\" }, \"list06\": { \"bunrui\": \"太刀\", \"touha\": \"三池\", \"name\": \"大典太光世\", \"nameyomi\": \"おおでんたみつよ\", \"bikou\": \"天下五剣のひとつで、三池典太光世作の太刀。同時代の刀剣とは作風が隔絶しており、その異質さからか枕元に置けば病も治るとされた霊刀。三日月宗近と並ぶ足利将軍家の宝刀で、将軍家の没落により豊臣秀吉に献上され、さらに秀吉が前田利家に与え、以後は前田家の家宝となった。\" }, \"list07\": { \"bunrui\": \"太刀\", \"touha\": \"三池\", \"name\": \"ソハヤノツルキ\", \"nameyomi\": \"そはやのつるぎ\", \"bikou\": \"無銘であるが、三池典太光世作と伝わる太刀。坂上田村麻呂の佩刀であった「ソハヤの剣」（坂上宝剣）の写し。徳川家康が所持し、死後霊刀として一緒に葬られたと言われている。\" }, \"list08\": { \"bunrui\": \"太刀\", \"touha\": \"青江\", \"name\": \"数珠丸恒次\", \"nameyomi\": \"じゅずまるつねつぐ\", \"bikou\": \"天下五剣のひとつで、青江恒次作との説がある太刀。ただし、その特徴は古青江派とは逸する部分が多く、現在は鎌倉初期に活躍した備前恒次(びぜんつねつぐ)の作ではないか、とも目されている。後に天下五剣に数えられた。法華宗(日蓮宗)の開祖・日蓮上人の「三遺品」に数えられ、甲斐国身延山久遠寺が所蔵していたが、故あって現在は兵庫県尼崎市の本興寺が所蔵している。\" }, \"list09\": { \"bunrui\": \"脇差\", \"touha\": \"青江\", \"name\": \"にっかり青江\", \"nameyomi\": \"にっかりあおえ\", \"bikou\": \"備中青江派の大脇差。大太刀が磨上げられて今の姿になっている。実体のない女の幽霊すら斬ると伝説が残る名刀。女の幽霊を切った人物についても諸説あるがその後刀は柴田勝家に所有が移り、子の柴田勝敏に譲られた。さらに柴田勝敏を討った丹羽長秀から豊臣秀吉に献上され、子の豊臣秀頼から京極高次に与えられ以降京極家に秘蔵される。江戸時代の狂歌に京極家について歌ったものがありそのなかで 『京極にすぎたるものが三つある。ニッカリ茶壺に多賀越中』とにっかり青江の名もあがっており、当時から名品として有名だったことが伺える。 \" }, \"list10\": { \"bunrui\": \"打刀\", \"touha\": \"粟田口\", \"name\": \"鳴狐\", \"nameyomi\": \"なきぎつね\", \"bikou\": \"粟田口国吉作の打刀。鎌倉時代のものとして打刀は珍しく、差表に銘が掘られているのが特徴。鳴狐という名前の由来は不明だが、出羽国山形藩の秋元家に伝来していた。「刀 銘左兵衛尉藤原国吉」の名称で、重要文化財に指定されている。\" }, \"list11\": { \"bunrui\": \"太刀\", \"touha\": \"粟田口\", \"name\": \"一期一振\", \"nameyomi\": \"いちごひとふり\", \"bikou\": \"短刀作りの名手として知られる粟田口吉光の太刀。粟田口吉光は正宗と並ぶ名工とされるが、その作品は短刀ばかりで太刀は数えるほどしか作られず、その中でも素晴らしい出来とされ、「一期一振」と呼ばれた。 戦国時代、朝倉氏が所有していたが、朝倉氏滅亡後は毛利氏の物となり、毛利輝元より豊臣秀吉に献上された。小柄な体格であった秀吉は、自分の体格に合わせて、刃長が2尺8寸3分（約86cm）あった一期一振を、2尺2寸7分（約69cm）に磨上げた。秀吉の死後も豊臣氏に伝えられていたが、豊臣氏滅亡後は徳川家に伝わる。その後、大阪夏の陣もしくは明暦の大火により一期一振は焼身となるも、徳川家は越前康継（年代的に二代目、もしくは三代目）に打ち直させた。こうして蘇った一期一振は尾張徳川家に伝えられた。幕末に至り、文久3年（1863年）、尾張藩主・徳川茂徳より孝明天皇に献上された。以後、皇室に伝えられ、皇室御物となっている。\" }, \"list12\": { \"bunrui\": \"脇差\", \"touha\": \"粟田口\", \"name\": \"鯰尾藤四郎\", \"nameyomi\": \"なまずおとうしろう\", \"bikou\": \"鎌倉時代に活躍した刀工 粟田口吉光作の脇差。由来は、鯰の尾を連想させる”ふくら”がふっくらした姿から「鯰尾」の異名を持つ。元は小薙刀であったが、大坂夏の陣で焼身となる。初代越前康継によって磨り上げられ、脇差としてその姿を今に残す。 \" }, \"list13\": { \"bunrui\": \"脇差\", \"touha\": \"粟田口\", \"name\": \"骨喰藤四郎\", \"nameyomi\": \"ほねばみとうしろう\", \"bikou\": \"薙刀を磨り上げて寸を詰めた、薙刀直しの脇差。鎌倉時代中期の刀工・粟田口吉光の作。号の由来は、『斬る真似をしただけで骨が砕ける』とされたこと。大阪夏の陣の大阪城落城の際、奇跡的に堀の中から無傷で回収されたが、1657年の明暦の大火で焼身となる。その後修復され、現在は重要文化財に指定されている。\" }, \"list14\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"平野藤四郎\", \"nameyomi\": \"ひらのとうしろう\", \"bikou\": \"鎌倉時代中期の刀工、粟田口吉光の作の短刀。刃長は短刀としては長く、一尺(30.3cm)にも及ぶ。木村重茲が摂津の商人・平野道雪より金三十枚で買い求めた事から、この名で呼ばれるようになった。前田家と徳川家の間を一往復した(重茲から豊臣秀吉へ献上され、前田利長が拝領。この利長から徳川秀忠へ献上され、再度、前田利光が拝領した)。\" }, \"list15\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"厚藤四郎\", \"nameyomi\": \"あつしとうしろう\", \"bikou\": \"室町時代から名物として名高く、寸法が短く極めて小ぶりであるが、刀身が極端に厚いことから「厚藤四郎」と呼ばれた。 読みについては、「あつとうしろう」「あつしとうしろう」の両方がある。埋忠押型には仮名で「安徒（あつ）藤四郎」となっている。なお、この刀のように身幅が狭く重ねが極端に厚い、頑丈な造り込みの短刀は「鎧通し」と呼ばれる。\" }, \"list16\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"後藤藤四郎\", \"nameyomi\": \"ごとうとうしろう\", \"bikou\": \"鎌倉時代中期の刀工、京の粟田口藤四郎吉光作の短刀。江戸幕府の御金改役（金座の元締）であった後藤庄三郎光次が所持していたことが名前の由来。平造、三つ棟、内反、やや大振りの短刀で目釘孔下に「吉光」の二字銘が入っている。\" }, \"list17\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"信濃藤四郎\", \"nameyomi\": \"しなのとうしろう\", \"bikou\": \"鎌倉時代中期の刀鍛冶で短刀作りの名手と呼ばれた粟田口吉光により作られた短刀である。元々は秀吉が所持していたもので、後に関ヶ原合戦にも参加したことのある徳川家康の家臣で元老中・永井信濃守尚政に渡ったことが名の由来。その後、徳川将軍家へ献上された。\" }, \"list18\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"前田藤四郎\", \"nameyomi\": \"まえだとうしろう\", \"bikou\": \"鎌倉時代中期の刀鍛冶で短刀作りの名手と呼ばれた粟田口義光により作られた短刀である。加賀前田家の前田孫四郎利政が所持していたためこの名がついた。\" }, \"list19\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"秋田藤四郎\", \"nameyomi\": \"あきたとうしろう\", \"bikou\": \"鎌倉時代の刀工・粟田口藤四郎吉光の打った短刀。豊臣秀吉に仕えた秋田実季の所持であったことからこの名で呼ばれる。刀身の表に梵字と素剣、裏に護摩箸の彫物がある。\" }, \"list20\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"博多藤四郎\", \"nameyomi\": \"はかたとうしろう\", \"bikou\": \"鎌倉時代の刀工・粟田口藤四郎吉光の打った短刀。「博多藤四郎」の号は黒田忠之が小倉表の海上で、小笠原忠真にこの短刀を贈った事が由来となっており、黒田領地である博多から出てきた道具のため、博多藤四郎と呼ばれるようになった。\" }, \"list21\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"乱藤四郎\", \"nameyomi\": \"みだれとうしろう\", \"bikou\": \"鎌倉時代の刀工・粟田口藤四郎吉光の打った短刀。藤四郎としては珍しく乱れ刃を持ち、これが号の由来ともなっている。室町時代、細川勝元の所持となっていた時に名付けられたとされる。江戸時代には忍藩・白河藩藩主を歴任した阿部家に伝来。\" }, \"list22\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"五虎退\", \"nameyomi\": \"ごこたい\", \"bikou\": \"鎌倉時代の刀工・粟田口藤四郎吉光の打った短刀。上杉謙信が上洛した際に正親町天皇より拝領。足利義満の遣明使として明に向かった役人が五頭の虎に襲われた時この短刀で追い払ったといういわれがある。\" }, \"list23\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"薬研藤四郎\", \"nameyomi\": \"やげんとうしろう\", \"bikou\": \"鎌倉時代の刀工・粟田口藤四郎吉光の打った短刀。名前の由来は室町期の武将・畠山政長がこの刀で切腹しようとしたが、何度試しても腹に刺さらず、政長が苛立って投げつけると、そこにあった薬研を見事に貫いたことによる。その後、足利将軍家に伝来。しかし十三代将軍・足利義輝が殺された折に、松永久秀に奪われる。 久秀は織田信長にこの刀を献上し、これを気に入った信長は愛刀として常に肌身離さず所持し、本能寺の変で横死するまで傍に置いたという。本能寺の変に於いて薬研藤四郎は焼失したとされるのが一般的な説であるが、異説ではその後豊臣秀吉の手に渡ったとも、更に徳川将軍家に伝えられたともある。「享保名物帳」には焼身として名を記載されているが、現在、その所在は解らない。\" }, \"list24\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"包丁藤四郎\", \"nameyomi\": \"ほうちょうとうしろう\", \"bikou\": \"「ホウチョウトウシロウ」と同じ読みをする刀は二振りある。どちらも徳川家に関係する刀であるが、記録によると明らかに長さが違うため、別刀だと考えられている。また、一方は美術館で保存されているが、もう一方は明暦の大火で焼失してしまっている。\" }, \"list25\": { \"bunrui\": \"太刀\", \"touha\": \"古備前\", \"name\": \"大包平\", \"nameyomi\": \"おおかねひら\", \"bikou\": \"12世紀頃、備前三平がひとり備前国の包平によって作刀されたといわれる。古備前派。包平の刀は通常「包平」と二文字で銘が切られているがこの刀は「備前国包平作」と長い銘がきられている。刃長は実測で89.2cm。幅が広く、反りが高く、大きさの割に非常に軽い。日本一との誉れも高き日本刀であり、童子切安綱と並んで日本刀の東西両横綱と称される程の刀で「日本刀の最高傑作」として知られている。\" }, \"list26\": { \"bunrui\": \"太刀\", \"touha\": \"古備前\", \"name\": \"鶯丸\", \"nameyomi\": \"うぐいすまる\", \"bikou\": \"平安時代中頃に興った備前国の日本刀刀工一派、古備前派の備前国友成による太刀。現存する友成の作った刀の中で最も古いものの一つである。皇室に伝来した所蔵品である「御物」であり、現在は宮内庁が管理している。御物であるため、慣例的に国宝や重要文化財などの指定は受けていない。「鶯丸」と言う名前の由来については不明だが、室町時代には既にこの呼称だったという。 \" }, \"list27\": { \"bunrui\": \"太刀\", \"touha\": \"来\", \"name\": \"明石国行\", \"nameyomi\": \"あかしくにゆき\", \"bikou\": \"来派の祖である来国行の作で、国宝に指定されている。播磨国明石松平家伝来のため「明石国行」の号を持つ。身幅広く、腰反り高く、中切先の鎌倉時代中期特有の体配であるが、国行の作中ではやや細身に属する。地鉄は小板目つみ、やや肌立ち、刃文は広直刃調に丁子を交え、刃中の働きが盛んなものである。茎は生ぶで雉股形となり、茎尻に手抜き緒通しの孔があり、貴重である。\" }, \"list28\": { \"bunrui\": \"大太刀\", \"touha\": \"来\", \"name\": \"蛍丸\", \"nameyomi\": \"ほたるまる\", \"bikou\": \"来国俊によって作られた大太刀。南北朝時代の武将・阿蘇惟澄が実戦で使用した際に、刃こぼれした刀に蛍が集まって直ったという夢を見て、目が覚めたら本当に刀が治っていた……という逸話から名づけられている。国宝指定され阿蘇神社に保管されていたが、太平洋戦争の戦火に巻き込まれ、現在は行方不明となっている。\" }, \"list29\": { \"bunrui\": \"短刀\", \"touha\": \"来\", \"name\": \"愛染国俊\", \"nameyomi\": \"あいぜんくにとし\", \"bikou\": \"鎌倉時代・後期に京都で活躍した来派の刀工、国俊（二字国俊）が打った刀。「国俊」と二字に切られた銘を持つ。名前は茎の表に仏教の愛染明王が彫られていることに由来する。元々、豊臣秀吉が所蔵していたが、その後徳川家康の手に渡り、元和2年（1616年）大坂の陣で戦功のあった森忠政（森蘭丸の弟・千丸）に下賜された。忠政の死後、遺物として3代将軍・徳川家光に献上され、後に前田家へ贈り物とされた。現在は重要文化財に指定されている。 \" }, \"list30\": { \"bunrui\": \"打刀\", \"touha\": \"村正\", \"name\": \"千子村正\", \"nameyomi\": \"せんごむらまさ\", \"bikou\": \"初代村正（千子村正）の作で、恐ろしいほどの切れ味を持つ実戦向きの打刀。史上最も有名な刀工名の一つ。その作は武器としての日本刀の代名詞で、斬味凄絶無比と名高く、精強で知られる三河武士を中心に、将軍徳川家康・関白豊臣秀次ら天下人を含む戦国時代の武将から至上の業物（実戦刀）として愛用された。\" }, \"list31\": { \"bunrui\": \"槍\", \"touha\": \"村正\", \"name\": \"蜻蛉切\", \"nameyomi\": \"とんぼきり\", \"bikou\": \"本多忠勝が使用した名槍。天下三名槍の一つに数えられる。穂先に止まった蜻蛉が真っ二つになったことが名の由来だと言われるが、異説もある。\" }, \"list32\": { \"bunrui\": \"脇差\", \"touha\": \"貞宗\", \"name\": \"物吉貞宗\", \"nameyomi\": \"ものよしさだむね\", \"bikou\": \"相州貞作の脇差。徳川家康の愛刀で、これを帯びて出陣すると必ず勝利を得たことから「物吉」と名づけられたと伝わる。\" }, \"list33\": { \"bunrui\": \"短刀\", \"touha\": \"貞宗\", \"name\": \"太鼓鐘貞宗\", \"nameyomi\": \"たいこがねさだむね\", \"bikou\": \"無銘ながら相州貞宗の作とされ、貞宗作中もっとも小振り。長く伊達家に在った短刀。伊達家では「太鼓馨」とも書く。重要文化財に指定されている。\" }, \"list34\": { \"bunrui\": \"打刀\", \"touha\": \"貞宗\", \"name\": \"亀甲貞宗\", \"nameyomi\": \"きっこうさだむね\", \"bikou\": \"刀工正宗の実子あるいは養子といわれている刀匠、相州貞宗作の無銘貞宗が一振。茎（なかご）に亀甲菊花文の彫物があるのが特徴で、表は掻き流し、裏は掻き通しの乱れ刃。無銘貞宗の中ではこの亀甲の彫物が特徴となっているため、現在の通称がついた。元々は雲州松江藩の藩祖である松平出羽守直政が所持していた刀で、この亀甲紋は松江藩ではおなじみ出雲大社で使用されている『二重亀甲に剣花菱』をヒントにしたのではという説もあるが真偽は不明。\" }, \"list35\": { \"bunrui\": \"太刀\", \"touha\": \"長船\", \"name\": \"燭台切光忠\", \"nameyomi\": \"しょくだいきりみつただ\", \"bikou\": \"伊達政宗が所有していた太刀で、備前の刀工光忠の作。「しょくだい『き』り」と「しょくだい『ぎ』り」の読み方ブレがあるが前者のほうが一般的。現在は確認できないが『武庫刀纂』に残る押形と『大日本刀剣史』の記述に撚れば蕨手丁子の変り出来の、光忠らしい華やかな刃紋の刀であったという。茎に目釘孔が二個あることから磨上げられた可能性がある。伊達政宗が家臣を斬った際に銅製（青銅、鉄などとも言われる）の燭台をも斬ったことから燭台切と号が付いた。\" }, \"list36\": { \"bunrui\": \"太刀\", \"touha\": \"長船\", \"name\": \"大般若長光\", \"nameyomi\": \"だいはんにゃながみつ\", \"bikou\": \"鎌倉時代末期の刀工、長光（ながみつ）の作。古備前の流れを組む長船の実質的な祖・光忠の子にして二代目。長船派を代表する刀工の一人である。「遠江長光」「鉋切長光」などの著名作が現存しており、古刀の中でも在銘の作が多い。号の由来は、室町時代に銭600貫という破格の代付（値付け）がされた事にある。当時の刀剣本「諸国鍛冶代付之事」によると、刀剣の値段にも刀工によって様々なランクがあり、刀剣鑑定師・本阿弥家による格付けがなされていた。\" }, \"list37\": { \"bunrui\": \"太刀\", \"touha\": \"長船\", \"name\": \"小竜景光\", \"nameyomi\": \"こりゅうかげみつ\", \"bikou\": \"鎌倉時代末期の刀工、景光（かげみつ）の作。古備前の流れを組み、光忠を祖とする長船派二代目・長光の子であり、その後を継承した三代目。長船派を代表する刀工の一人である。号の由来は、ハバキ元に倶利伽羅竜の彫り物がある事から。磨上によって刀身が短くなった結果、竜が柄に隠れてしまうようになった。この竜がわずかに顔を覗かせている事から「覗き竜景光」の異名を取る。\" }, \"list38\": { \"bunrui\": \"太刀\", \"touha\": \"左文字\", \"name\": \"江雪左文字\", \"nameyomi\": \"こうせつさもんじ\", \"bikou\": \"鎌倉～南北朝時代の刀工・左衛門尉安吉（左文字源慶）作。「筑州住 左」の銘が切られている。左文字は短刀を得意としており、左文字の銘が残る太刀で現存しているのはこの江雪左文字の一振のみである。左文字作で現存する唯一の太刀という希少性、歴史に名を残す人物が持っていたという史料的価値のほかに、純粋に刀剣としてみても非常に優れた作であるとされる。戦国時代の外交僧・板部岡江雪斎（いたべおかこうせつさい）の佩刀であり、名の由来も彼から来ている。\" }, \"list39\": { \"bunrui\": \"打刀\", \"touha\": \"左文字\", \"name\": \"宗三左文字\", \"nameyomi\": \"そうざさもんじ\", \"bikou\": \"鎌倉～南北朝時代の刀工・左衛門尉安吉（左文字源慶）作と伝わる。元々は二尺六寸の長さを持つ太刀であり、戦国時代に三好政長（宗三）から武田信虎（武田信玄の父）に贈られた刀であった事からこの名で呼ばれた。武田氏が今川氏との間に和睦を結んだ折に、信虎が娘・定恵院にこの刀を持たせ、信虎の娘婿となった今川義元はこの刀を愛刀として大切にしていたと伝わる。しかし1560年、桶狭間の戦いにおいて今川義元は討死。この戦いで義元に勝利した織田信長が戦利品としてこの刀を持ち帰り、短く磨り上げ、更に茎の表裏に「織田尾張信長」「永禄三年五月十九日義元討補刻彼所持持刀」と金象嵌銘を入れ、自分の愛刀とした。後に本能寺の変で横死するまで、信長の手元に置いてあったと伝えられている。\" }, \"list40\": { \"bunrui\": \"短刀\", \"touha\": \"左文字\", \"name\": \"小夜左文字\", \"nameyomi\": \"さよさもんじ\", \"bikou\": \"鎌倉～南北朝時代の刀工・左衛門尉安吉（左文字源慶）作。表に左、裏に筑州住の銘あり。小夜左文字には、一説として以下のような逸話がある。遠江国に暮らしていた浪人の死後、その妻が形見である左文字の短刀を掛川に売りに行く途中、小夜の中山で山賊に短刀を奪われて斬り殺された。その後、遺された息子は母親の妹に育てられ、成人した後に掛川の研師に弟子入りする。そしてある時、その息子の元に浪人が左文字の研ぎを頼みに来るが、息子は彼からその刀が母親を殺して奪ったものであるという話を聞き、左文字を見るふりをしてその浪人を殺し、仇を討ったという。しかしこの話は事実ではなく、江戸幕府第8代将軍・徳川吉宗が編纂を指示した『享保名物帳』に記載されたもので、小夜山の観音寺にある小説的な話に基づいたものであるとされている。\" }, \"list41\": { \"bunrui\": \"打刀\", \"touha\": \"なし\", \"name\": \"加州清光\", \"nameyomi\": \"かしゅうきよみつ\", \"bikou\": \"江戸時代の刀工・加州清光（加州金沢住長兵衛藤原清光）の作。清光の六代目に当たり、歴代の中で最も評価が高い。沖田総司が大和守安定と共に愛用したことでも知られている。沖田総司はかの池田屋事件において清光を振るい、文字通り獅子奮迅の働きをしたという。しかし戦いの最中に喀血に見舞われ昏倒してしまう。この戦いで加州清光は大きな被害を受け、後に研師が記す所によると「帽子（刀の切先）折れ、ささらの如く打ち欠け」という、壮絶なダメージを負った。沖田自身がこの刀の修復を望んだことは研師側の記録からも明らかであるが、結局、刀の命とも言える切先を失った加州清光は修復不能と判断され、そのまま破却されたという。\" }, \"list42\": { \"bunrui\": \"打刀\", \"touha\": \"なし\", \"name\": \"大和守安定\", \"nameyomi\": \"やまとのかみやすさだ\", \"bikou\": \"江戸時代の刀工、大和守安定作の打刀。安定は1618年紀伊国（現在の和歌山県）生まれとされ、30歳を前に江戸に出て和泉守兼重、あるいは二代康継（一期一振や鯰尾藤四郎を再刃した初代康継の子）に師事したと伝えられている。一説には長曽祢虎徹こと長曽祢興里に影響を与えたとも言われており、作風が似ているとされる。彼が打った刀は「新刀上々作にして良業物」と評価され、切れ味の鋭さに定評がある。三ツ胴（死体を３つ重ねて両断）を達成した刀が数多く伝えられており、中には五ツ胴を達成したとされる刀もある。しかし切れ味こそ素晴らしいが、反りが浅く剣先が細い為に使い手を選び、名人にしか使いこなせなかったと言われている。\" }, \"list43\": { \"bunrui\": \"打刀\", \"touha\": \"兼定\", \"name\": \"歌仙兼定\", \"nameyomi\": \"かせんかねさだ\", \"bikou\": \"二代関兼定こと和泉守兼定の作。刀の銘「兼定」の「定」の字の下を「之」と切ったことから「之定（のさだ）」と呼ばれた。生没年こそ不詳であるが、「関孫六」こと孫六兼元と人気を二分し、多くの武将・大名がこぞって刀を手に入れた。著名な所では「人間無骨」「鳴神兼定」「九字兼定」「立袈裟籠釣瓶」などが知られる。江戸時代には「千両兼定」と呼ばれて高値で取引され、新選組副長・土方歳三が之定作の刀を欲しがっていたとも伝えられている。また伊勢で仕事をした際に「千子村正」こと村正とも交流を持ち、秘伝を教わったという。これを裏付けるように、二人の銘が裏表に刻まれた合作の短刀が現存している。\" }, \"list44\": { \"bunrui\": \"打刀\", \"touha\": \"兼定\", \"name\": \"和泉守兼定\", \"nameyomi\": \"いずみのかみかねさだ\", \"bikou\": \"江戸後期～明治の刀工・十一代目兼定こと和泉守兼定（会津兼定）の作。（一説では十二代とも）新選組副長・土方歳三が、脇差の堀川国広と一緒に愛用していたと伝えられている。\" }, \"list45\": { \"bunrui\": \"打刀\", \"touha\": \"なし\", \"name\": \"陸奥守吉行\", \"nameyomi\": \"むつのかみよしゆき\", \"bikou\": \"刀工「陸奥守吉行」は西暦1650年（慶安3年）に摂津国住吉（現在では大阪府内）で生まれ、元禄年間に土佐藩に招かれて鍛治奉行となった人物。初代大和守吉道の弟子。名工として知られており、「新刃銘盡 後集（あらみめいづくし こうしゅう）」という刀剣書には彼の作が「刀鋒鋭利 南国新刀の冠」と称えられているという。坂本竜馬の愛刀として知られる打刀。\" }, \"list46\": { \"bunrui\": \"打刀\", \"touha\": \"堀川\", \"name\": \"山姥切国広\", \"nameyomi\": \"やまんばぎりくにひろ\", \"bikou\": \"安土桃山時代の刀工、堀川国広（ほりかわくにひろ）作の打刀。新刀（慶長以降に作られた刀）の刀工の代表格であり、堀川一門の祖である。最初は日向国（現在の宮崎県）において伊東家に家臣として仕えていたが、島津氏の侵攻により主家が滅亡してしまった。主君の遺児である伊東虎千代（後の伊東マンショ・天正遣欧少年使節の一人）を背負って豊後国（現在の大分県）まで落ち延び、幼君がキリスト教の庇護を受けてセミナリヨ（初等神学校）に入った後は流浪の日々を送る。山伏として修行していた時期もあり、山伏国広はこの頃打たれた作である。後に上野国（現在の栃木県）足利に移住。関東の最高学府である「足利学校」に籍を置き、天正18（1590）年、足利城城主・長尾顕長（ながおあきなが）の依頼で「山姥切」の写し、すなわち山姥切国広を鍛刀した。この時本科（手本）となった「山姥切」は備前長船派の長義（ちょうぎ）の作。長らく北条家に伝来していた刀であり、長尾顕長が北条氏直より拝領していた。\" }, \"list47\": { \"bunrui\": \"太刀\", \"touha\": \"堀川\", \"name\": \"山伏国広\", \"nameyomi\": \"やまぶしくにひろ\", \"bikou\": \"安土桃山時代の刀工、堀川国広（ほりかわくにひろ）作の太刀。新刀（慶長以降に作られた刀）の刀工の代表格であり、堀川一門の祖である。最初は日向国（現在の宮崎県）において伊東家に家臣として仕えていたが、島津氏の侵攻により主家が滅亡してしまった。主君の遺児である伊東虎千代（後の伊東マンショ・天正遣欧少年使節の一人）を背負って豊後国（現在の大分県）まで落ち延び、幼君がキリスト教の庇護を受けてセミナリヨ（初等神学校）に入った後は流浪の日々を送りながら刀を作り続けた。裏には「天正十二年二月彼岸 日州古屋之住國廣山伏之時作之」と銘が入っており、日向国の古屋で山伏修行をしていた時期に打たれた事が判る。また、表には「太刀主日向国住飯田新七良藤原祐安」と銘が入っている。この飯田祐安とは伊東家重臣・飯田祐恵の一人息子であり、父を島津氏に攻め滅ぼされた後に流浪の身となりながら再興を目指していたと伝えられる。彼の求めに応じて打たれた太刀の刀身には、修験者の信仰の対象である不動明王像と共に「武運長久」の文字、梵字が彫られている。\" }, \"list48\": { \"bunrui\": \"脇差\", \"touha\": \"堀川\", \"name\": \"堀川国広\", \"nameyomi\": \"ほりかわくにひろ\", \"bikou\": \"安土桃山時代の刀工、堀川国広（ほりかわくにひろ）作の太刀。新刀（慶長以降に作られた刀）の刀工の代表格であり、堀川一門の祖である。最初は日向国（現在の宮崎県）において伊東家に家臣として仕えていたが、島津氏の侵攻により主家が滅亡してしまった。主君の遺児である伊東虎千代（後の伊東マンショ・天正遣欧少年使節の一人）を背負って豊後国（現在の大分県）まで落ち延び、幼君がキリスト教の庇護を受けてセミナリヨ（初等神学校）に入った後は流浪の日々を送りながら刀を作り続けた。堀川国広、およびその一門が打った刀は出来の良さから「堀川物」と呼ばれ、大変珍重されたという。\" }, \"list49\": { \"bunrui\": \"打刀\", \"touha\": \"虎徹\", \"name\": \"蜂須賀虎徹\", \"nameyomi\": \"はちすかこてつ\", \"bikou\": \"江戸時代初期の甲冑師にして刀工・長曽祢興里（ながそねおきさと）こと長曽祢興里入道虎徹の作。長らく甲冑師として活躍していたが、太平の世となり甲冑の需要が減った事もあり、50歳を超えてから商売を替えたという。約20年に及ぶ活動の中で打たれた刀は第一級の評価を受けており、美術工芸品としてもきわめて優れていた。その為、大名や豪商によって大いにもてはやされるが、これが虎徹の贋作が世に横行する事態に繋がり、「虎徹を見たら偽物だと思え」というのは刀剣界の常識となっている。\" }, \"list50\": { \"bunrui\": \"脇差\", \"touha\": \"虎徹\", \"name\": \"浦島虎徹\", \"nameyomi\": \"うらしまこてつ\", \"bikou\": \"江戸時代初期の甲冑師にして刀工・長曽祢興里（ながそねおきさと）こと長曽祢興里入道虎徹の作。長らく甲冑師として活躍していたが、太平の世となり甲冑の需要が減った事もあり、50歳を超えてから商売を替えたという。約20年に及ぶ活動の中で打たれた刀は第一級の評価を受けており、美術工芸品としてもきわめて優れていた。その為、大名や豪商によって大いにもてはやされるが、これが虎徹の贋作が世に横行する事態に繋がり、「虎徹を見たら偽物だと思え」というのは刀剣界の常識となっている。銘に「萬治三年十二月日」と入っており、作刀された時期が明確に判明している。号の由来は、刀身に彫られた浦島太郎から。ちなみにこの彫物も興里によるもの。岩の上で釣竿を肩に乗せていることから浦島太郎と判じられているが、これに対して「実は浦島太郎ではないのでは」という指摘も上がっている。\" }, \"list51\": { \"bunrui\": \"打刀\", \"touha\": \"虎徹\", \"name\": \"長曽祢虎徹\", \"nameyomi\": \"ながそねこてつ\", \"bikou\": \"江戸時代初期の甲冑師にして刀工・長曽祢興里（ながそねおきさと）こと長曽祢興里入道虎徹の作。長らく甲冑師として活躍していたが、太平の世となり甲冑の需要が減った事もあり、50歳を超えてから商売を替えたという。約20年に及ぶ活動の中で打たれた刀は第一級の評価を受けており、美術工芸品としてもきわめて優れていた。その為、大名や豪商によって大いにもてはやされるが、これが虎徹の贋作が世に横行する事態に繋がり、「虎徹を見たら偽物だと思え」というのは刀剣界の常識となっている。新撰組局長・近藤勇の佩刀として知られている。しかし虎徹は幕末においても極めて高価であり、一介の浪士の手に渡るのは到底不可能だった。その為、江戸時代後期の刀工・源清麿（みなもとのきよまろ）が打った刀に虎徹の銘を切った偽物だったという説が、現在では一般的である。近藤自身は自分の刀を虎徹と信じており、池田屋事件の後、養父宛てにしたためた手紙において「下拙刀は虎徹故に哉、無事に御座候」とある。\" }, \"list52\": { \"bunrui\": \"太刀\", \"touha\": \"なし\", \"name\": \"髭切\", \"nameyomi\": \"ひげきり\", \"bikou\": \"源家の重代の刀として伝えられる重宝。もとは平安時代に膝丸と揃いで作られたとされる。『平家物語』の『剣巻』に語られる伝承によると、平安時代に源満仲（みなもとのみつなか）の命により、筑前国に住む唐国の刀工が八幡大菩薩の加護を得て、膝丸と揃いで作られたと伝わる。罪人を試し切りした際に髭まで切れた、というのが最初の名の由来である。\" }, \"list53\": { \"bunrui\": \"太刀\", \"touha\": \"なし\", \"name\": \"膝丸\", \"nameyomi\": \"ひざまる\", \"bikou\": \"源家の刀として伝えられる重宝。もとは平安時代に髭切と揃いで作られたとされる太刀。源義経や曽我兄弟の仇討ちとは縁が深い刀で、髭切とは何度も名前が変わるさまも同じ、という数奇な運命をたどる。『平家物語』の『剣巻』に語られる伝承によると、平安時代に源満仲（みなもとのみつなか）の命により、筑前国に住む唐国の刀工が八幡大菩薩の加護を得て、膝丸と揃いで作られたと伝わる。罪人を試し切りした際に両膝を両断した、というのが最初の名の由来である。\" }, \"list54\": { \"bunrui\": \"打刀\", \"touha\": \"なし\", \"name\": \"大倶利伽羅\", \"nameyomi\": \"おおくりから\", \"bikou\": \"正式な名称は「大倶利伽羅廣光（おおくりからひろみつ）」。無銘ではあるが、南北朝時代の刀工・相州廣光（そうしゅうひろみつ）の作と伝えられる。来歴は不明だが、伊達政宗が徳川秀忠から拝領した刀。刀身に倶利伽羅竜が彫られており、これが名の由来である。元和6（1620）年に江戸城の石垣を改修した折に褒美として贈られたが、当時の伊達政宗は仙台にいた為、息子の伊達忠宗が拝領した。明治に入り仙台から東京に移され、昭和4（1929）年に開催された日本名宝展覧会には伊達興宗伯爵所持として、太鼓鐘貞宗と共に出展されている。昭和初期まで伊達家に伝来。現在は法人蔵で、重要美術品として登録されている。\" }, \"list55\": { \"bunrui\": \"打刀\", \"touha\": \"なし\", \"name\": \"へし切長谷部\", \"nameyomi\": \"へしきりはせべ\", \"bikou\": \"鎌倉時代の末期から南北朝時代にかけて活躍した刀工の長谷部国重の最高傑作と云われている。国重は建武期（1334年～1336年）頃（延文年間：1356年～1361年に活躍したとの説もあり）の山城国（現在の京都府）の刀工だが、鎌倉時代に相州伝を完成させた岡崎五郎入道正宗の弟子で、「正宗十哲」の一人とされている。名の由来は、信長が膳棚の下に隠れた茶坊主をその棚ごと圧し切ったことから。\" }, \"list56\": { \"bunrui\": \"短刀\", \"touha\": \"なし\", \"name\": \"不動行光\", \"nameyomi\": \"ふどうゆきみつ\", \"bikou\": \"鎌倉の刀工、藤三郎行光（とうざぶろうゆきみつ）の作。相州正宗の父とされ、五箇伝のひとつ・相州伝に山城伝の影響を与えた人物。在銘の太刀は皆無ながら、無銘の極めものとされている。短刀のうち一振が国宝、一振が御物となっている。その他にも多くの作が重要文化財指定を受け、徳川家に伝来した「矢目行光」「綾小路行光」など在銘の著名作がある。号は、表の櫃の中に不動明王とその眷属である矜羯羅（こんがら）・制多迦（せいたか）の両童子を浮彫にしている事に由来。織田信長が所有し、これを非常に自慢していた。酒に酔って気分が良くなると、膝を叩きながら「不動行光、つくも髪、人には五郎左御座候」と歌ったという。\" }, \"list57\": { \"bunrui\": \"太刀\", \"touha\": \"なし\", \"name\": \"獅子王\", \"nameyomi\": \"ししおう\", \"bikou\": \"平安時代末期の大和刀工の作とされる太刀。無銘だが、号として「獅子王」の名が与えられている。刀身の厚みが薄く身幅が低い、同時代のものと比べても全体的に小振りな太刀で、源頼政が拝領した際には102.5センチの大太刀であったとする資料もあるため、現状の刀身は摺り上げが行われたうえ作刀時からは大幅に研ぎ減っている状態であるとの解釈もあった。\" }, \"list58\": { \"bunrui\": \"太刀\", \"touha\": \"なし\", \"name\": \"小烏丸\", \"nameyomi\": \"こがらすまる\", \"bikou\": \"奈良または平安時代の刀工・天国（あまくに）作とされる刀。日本刀剣の祖とされる伝説の刀工であり、その経歴には謎が多い。天国作の他にも、桓武天皇の御代、御所に現れた八咫烏が伊勢神宮の使いを名乗り、刀を献上したという伝承が存在する。最大の特徴は、その切っ先にあり、剣（つるぎ）から刀への変遷を示すかのように、刀身の中程から切先にかけてが両刃となっている。また、ゆるやかな反りこそあるが、切っ先はほぼ真っ直ぐになっている。これは「鋒両刃造（きっさきもろはづくり）」または「小烏造（こからすづくり）」と呼ばれ、切断と刺突の両方に向いているとされる。\" }, \"list59\": { \"bunrui\": \"打刀\", \"touha\": \"なし\", \"name\": \"同田貫正国\", \"nameyomi\": \"どうだぬきまさくに\", \"bikou\": \"同田貫は九州・肥後国（現在の熊本県）菊池の同田貫を本拠地として、室町時代末期に成立した刀工集団である。その初代とされるのが、清国・正国の兄弟である。肥後熊本藩を領した加藤清正により庇護され、兄弟の名はそれぞれ「清」「正」の字を拝領している。熊本城の常備刀として多くの刀が配されたが、加藤家改易によって一時衰退。その後9代目の正勝に始まる「新々刀」としての同田貫が再び隆盛した。装飾を全くと言っていいほど加えない質素な造りが特徴。高価なわりに、現代の刀剣界において評価は低い。しかし『天覧兜割り』の逸話で一躍有名になった一振りが「同田貫正国」としてよく知られる。\" }, \"list60\": { \"bunrui\": \"太刀\", \"touha\": \"なし\", \"name\": \"鶴丸国永\", \"nameyomi\": \"つるまるくになが\", \"bikou\": \"平安時代の刀工・五条国永作と伝えられる太刀。号の由来は不明。国永は三日月宗近の作者である三条宗近の孫、または弟子にあたる。刃長は二尺五寸九分半（78.63cm）。細身で鋒が小さく、優雅で洗練された姿。武器というより美術品として優れているが、棟に三ヶ所の誉傷があり実践で使われていたことが判明している。また鶴丸は五条派だが、三条派と五条派の刀剣をまとめて三条物と呼び、鶴丸は三条物で最も洗練されると評されている。形状が三日月に酷似していることから三日月を手本にして打たれたのではないかという説があり、過去の展覧会では並んで展示されていたことも。\" }, \"list61\": { \"bunrui\": \"大太刀\", \"touha\": \"なし\", \"name\": \"太郎太刀\", \"nameyomi\": \"たろうたち\", \"bikou\": \"越前の刀匠・千代鶴が手がけた大太刀。五尺三寸（約175cm）～九尺五寸（288cm）と記録されていることが多い。現在の奉納先である熱田神宮宝物館にあるものは221.5cm、4.5kgとなる。\" }, \"list62\": { \"bunrui\": \"大太刀\", \"touha\": \"なし\", \"name\": \"次郎太刀\", \"nameyomi\": \"じろうたち\", \"bikou\": \"刃渡り166.7cm。真柄直隆の長子、真柄隆基が用いたとされる巨大な太刀。千代鶴国安の朱銘があり、現在は太郎太刀とともに愛知県にある熱田神宮に奉納され、熱田神宮宝物館に現存する。\" }, \"list63\": { \"bunrui\": \"槍\", \"touha\": \"なし\", \"name\": \"日本号\", \"nameyomi\": \"にほんごう\", \"bikou\": \"天下三名槍のひとつで、「日の本一の槍」と称えられる。黒田藩の重臣 母里太兵衛が、福島正則との呑み賭で勝ち取ったという伝承から、別名「呑み取りの槍」とも呼ばれる。\" }, \"list64\": { \"bunrui\": \"槍\", \"touha\": \"なし\", \"name\": \"御手杵\", \"nameyomi\": \"おてぎね\", \"bikou\": \"室町時代に駿河国嶋田の刀工・五条義助が鍛えた大身槍。日本号・蜻蛉切と並んで天下三名槍と称される。江戸時代には「西に黒田の日本号あり、東に松平の御手杵あり」とも言われていた。下総国の大名・結城晴朝が作らせ、その養嗣子・結城秀康に伝わった。名の由来は「鞘が細長くくびれていて手杵のようだった」という伝承から。後世では参勤交代用に、大きな杵を象った熊毛鞘に収められていた。最大の特徴として、尋常ではない大きさの穂（刃長）が挙げられる。切先から石突までの拵えを含めた全長は約3.8m。槍身は穂（刃長）が4尺6寸（138cm）、茎（柄に埋まってる部分）まであわせると全長7尺1寸（215cm）にもなる。刃の断面は三角形になるために斬ったり薙いだりはできず、あくまで突きに特化した槍である。玉鋼をこの形に成形する事は極めて難しいとされ、刀工の高い技術を表している。\" }, \"list65\": { \"bunrui\": \"薙刀\", \"touha\": \"なし\", \"name\": \"巴形薙刀\", \"nameyomi\": \"ともえがたなぎなた\", \"bikou\": \"薙刀の形で、切先のほうが強く反り、かつ幅広になったもの。平安時代・巴御前所持の名に因んだものではないが、江戸期になってから、婦人用に作られた薙刀の形となる。 因みに京都上京区の興聖寺に、巴御前所持として「吉次」と在銘の薙刀や、木曽義仲所用として、「波平家次」在銘の太刀が伝来していた。刀身の幅が狭く反りの少ないものは静御前にちなんで男性用の薙刀『静型』、逆に刀身の幅が広く反りが大きい物は巴御前にちなんで女性用の薙刀『巴型』と呼ばれている。\" }, \"list66\": { \"bunrui\": \"短刀\", \"touha\": \"粟田口\", \"name\": \"毛利藤四郎\", \"nameyomi\": \"もうりとうしろう\", \"bikou\": \"鎌倉時代中期の刀工・粟田口吉光作の短刀。短刀作りの名手として知られており、刃長は8寸8分5厘（26.5cm）。号の由来は戦国時代の大名、毛利輝元が所持していたことから。\" }, \"list67\": { \"bunrui\": \"脇差\", \"touha\": \"なし\", \"name\": \"篭手切江\", \"nameyomi\": \"こてぎりごう\", \"bikou\": \"南北朝時代の刀工、郷義弘（ごうのよしひろ/ごうよしひろ）作の脇差。郷義弘は越中国新川郡（現在の富山県魚津市）松倉郷に住んだ事から、この名字で呼ばれた。なお江戸時代以降、「郷」は「江」と表記されている。鎌倉時代末期の刀工・正宗の高弟「正宗十哲」の一人に数えられ、「享保名物帳」では正宗、粟田口吉光と並び「名物三作」と称され、おおいに珍重された。しかし在銘の刀が皆無である事から偽物も多く、刀剣鑑定家・本阿弥家が鑑定した作、後世において郷義弘作であると認定された作しか存在しない。このため「郷（江）とお化けは見た事がない」と言われるほど希少な刀剣であり、「全ての日本刀の中で最も入手困難なものの一つ」とも呼ばれている。号の「篭手切」の由来は不明。「篭手切」自体は裁断銘（切れ味の良さを茎に記したもの）としてよく用いられる表現で、同じ号を持つ著名な刀剣も多い。表に金象嵌で「コテ切義弘 本阿（花押）」、裏に銀象嵌で「稲葉丹後守所持」と入る他、不動明王の種字が彫られている。\" }, \"list68\": { \"bunrui\": \"短刀\", \"touha\": \"長船\", \"name\": \"謙信景光\", \"nameyomi\": \"けんしんかげみつ\", \"bikou\": \"鎌倉時代末期の刀工、景光（かげみつ）の作。古備前の流れを組み、光忠を祖とする長船派二代目・長光の子であり、その後を継承した三代目。長船派を代表する刀工の一人である。御物の太刀2口、国宝の太刀2口・短刀1口を始め、多くの作が後世に伝わっている。銘に「元亨三年三月日」と入っており、正確に作刀年のわかる貴重な一振。刀身の表に「秩父大菩薩」、裏に大威徳明王の梵字「キリーク」が掘られている。秩父大菩薩は秩父神社の祭神・妙見菩薩、大威徳明王は阿弥陀如来（または文殊菩薩）が悪鬼を調伏する為に変じた憤怒尊。共に戦勝祈願を込めて崇敬される神仏である。号は上杉謙信が所持、常に身近に置いていた事に由来する。\" }, \"list69\": { \"bunrui\": \"太刀\", \"touha\": \"長船\", \"name\": \"小豆長光\", \"nameyomi\": \"あずきながみつ\", \"bikou\": \"鎌倉時代末期の刀工、長光（ながみつ）の作。古備前の流れを組む長船の実質的な祖・光忠の子にして二代目。長船派を代表する刀工の一人である。国宝「大般若長光」をはじめ「遠江長光」「鉋切長光」などの著名作が現存しており、古刀の中でも在銘の作が多い。言い伝えによると、上杉謙信の愛刀であったとされている。号の由来は、さる男が小豆の入った袋を背負って歩いていた時、袋からこぼれた小豆が、男が携えていた刀に当たって真っ二つに割れていたというもの。これを見た謙信の家臣・竹俣三河守が切れ味鋭い刀と見て買い上げ、謙信の手に渡った。「甲陽軍鑑」によると、第四次川中島の戦いにおいて、謙信は愛馬・放生月毛に跨り、小豆長光を手に宿敵・武田信玄の陣に突撃。一騎打ちとなり、馬上から太刀を振るったのを信玄が軍扇で払いのけた「三太刀七太刀」の逸話が知られている。\" }, \"list70\": { \"bunrui\": \"短刀\", \"touha\": \"正宗\", \"name\": \"日向正宗\", \"nameyomi\": \"ひゅうがまさむね\", \"bikou\": \"鎌倉時代末期～南北朝の刀工、正宗作の短刀。正宗は「五郎入道正宗」「岡崎五郎入道」とも称される、日本刀剣の歴史において最も有名な刀工。父は行光、子（養子とも）に貞宗。新藤五国光は正宗の師とされる。刀剣の五つの流派「五箇伝」の一つ・相州伝を確立、後世の作刀に大きな影響を与えた。また弟子（※一部には直弟子でない者も）に「正宗十哲」と呼ばれる十人の名工が知られており、何れも名刀を残している。著名作には「太郎作正宗」「観世正宗」「中務正宗」「石田正宗（石田切込正宗）」などが知られており、多くが国宝や重要文化財指定を受けている。\" }, \"list71\": { \"bunrui\": \"薙刀\", \"touha\": \"なし\", \"name\": \"静形薙刀\", \"nameyomi\": \"しずかがたなぎなた\", \"bikou\": \"静形薙刀は、源義経の愛妾：静御前の薙刀と同型の薙刀で、反り浅く、先幅の広くならないもの、つまり菖蒲造りの刀のようなもの、一名、シズ型ともいう。 志津三郎兼氏がこの型の薙刀を造ったからともいう。しかし、静流薙刀術の所伝では、源義経が鞍馬山時代、鞍馬寺の僧に鬼一法眼の弟子がいて、それから学んだ剣術から薙刀術を工夫し、愛妾の静御前だけに教えた。それが静流薙刀術であるが、薙刀の形や長さに規程はなし。刀身の幅が狭く反りの少ないものは静御前にちなんで男用の薙刀『静型』、逆に刀身の幅が広く反りが大きい物は巴御前にちなんで女用の薙刀『巴型』と呼ばれている。\" }, \"list72\": { \"bunrui\": \"打刀\", \"touha\": \"なし\", \"name\": \"南泉一文字\", \"nameyomi\": \"なんせんいちもんじ\", \"bikou\": \"鎌倉時代初期の刀工集団、福岡一文字の作品。祖は古備前の「菊一文字」こと則宗とされ、備前国（現在の岡山県）福岡の発祥である事からこの名で呼ばれる。「一文字」と呼ぶ場合はこの福岡一文字か、鎌倉時代末期に起こった吉岡一文字のどちらかになる。後鳥羽院が定めた御番鍛冶にも一文字の刀工は多く、先に上げた則宗の他、12人中7名にのぼる。一文字は比較的無銘の作が多く、作風によって見極められる事がほとんど。南泉一文字も無銘で、刀工までは特定できていない。共通して華やかな作風が特徴。名刀が数多く伝来し、国宝・重文指定を受けているものも多い。著名作には「道誉一文字」（御物）、「山鳥毛」（国宝）、黒田家の「日光一文字」（国宝）、上杉家の「姫鶴一文字」（重要文化財）などが知られている。号の由来は、研ぎに出され壁に立てかけられていた所に、飛びかかった猫が真っ二つに斬れたという逸話に由来する。\" }, \"list73\": { \"bunrui\": \"太刀\", \"touha\": \"なし\", \"name\": \"千代金丸\", \"nameyomi\": \"ちよがねまる\", \"bikou\": \"琉球王国（琉球国/現在の沖縄県）の王族・尚家に伝来した刀剣。正式名称は「金装宝剣拵 刀身無銘（号 千代金丸）」。同じく伝来の刀剣に「治金丸（ちがねまる）」「北谷菜切（ちゃたんなーちりー）」があり、三振ともに「琉球国王尚家関係資料」として国宝指定を受けている。刀長は71.3cmで、地金は板目肌。表裏に五本の細樋が彫られている。琉球で作られたとされる拵は、従来の日本刀のそれとはかけ離れた独自の印象を与える。柄は大きく張り出しており、兜金（かぶとがね）には菊の彫物と共に「大世」と銘が入る。「大世」とは琉球王国第六代国王・尚泰久王（しょうたいきゅうおう）の神号「大世主（おおよのぬし）」を表すとされる。柄の長さも拳２つ分ほどで、片手用となっている。鍔には菊の紋と花と猪の目の透かしが入り、黄金の鞘と相まって大変華やか。なおこの鍔には「てかね丸」の文字が刻まれており、「千代金丸と治金丸は長い時の中で入れ替わった」という説が存在するが、真相は不明。\" }, \"list74\": { \"bunrui\": \"打刀\", \"touha\": \"なし\", \"name\": \"山姥切長義\", \"nameyomi\": \"やまんばぎりちょうぎ\", \"bikou\": \"南北朝時代の刀工である長義によって作られた刀の一つ。 むかし信濃国戸隠山中の山姥なる化け物を退治したことから「山姥切」と号した。作者の長義は備前長船の刀工で、長船四天王の一人に数えられる。相州正宗に弟子入りし、正宗十哲に数えられている。長船本流とは異なり、自由奔放な作風が特徴。\" } }"
        val mapper = jacksonObjectMapper()

        // jsonをdeserialize
        // 下の場合はjsonがColor型のオブジェクトにマッピングされる
        val toukenlist = mapper.readValue<Toukenlist>(json)

        // リストの項目となる文字列を配列で設定
        val items = arrayOf(toukenlist.list01.name, toukenlist.list02.name, toukenlist.list03.name, toukenlist.list04.name, toukenlist.list05.name, toukenlist.list06.name, toukenlist.list07.name, toukenlist.list08.name, toukenlist.list09.name, toukenlist.list10.name, toukenlist.list11.name, toukenlist.list12.name, toukenlist.list13.name, toukenlist.list14.name, toukenlist.list15.name, toukenlist.list16.name, toukenlist.list17.name, toukenlist.list18.name, toukenlist.list19.name, toukenlist.list20.name, toukenlist.list21.name, toukenlist.list22.name, toukenlist.list23.name, toukenlist.list24.name, toukenlist.list25.name, toukenlist.list26.name, toukenlist.list27.name, toukenlist.list28.name, toukenlist.list29.name, toukenlist.list30.name, toukenlist.list31.name, toukenlist.list32.name, toukenlist.list33.name, toukenlist.list34.name, toukenlist.list35.name, toukenlist.list36.name, toukenlist.list37.name, toukenlist.list38.name, toukenlist.list39.name, toukenlist.list40.name, toukenlist.list41.name, toukenlist.list42.name, toukenlist.list43.name, toukenlist.list44.name, toukenlist.list45.name, toukenlist.list46.name, toukenlist.list47.name, toukenlist.list48.name, toukenlist.list49.name,
                toukenlist.list50.name, toukenlist.list51.name, toukenlist.list52.name, toukenlist.list53.name, toukenlist.list54.name,
                toukenlist.list55.name, toukenlist.list56.name, toukenlist.list57.name, toukenlist.list58.name, toukenlist.list59.name,
                toukenlist.list60.name, toukenlist.list61.name, toukenlist.list62.name, toukenlist.list63.name, toukenlist.list64.name,
                toukenlist.list65.name, toukenlist.list66.name, toukenlist.list67.name, toukenlist.list68.name, toukenlist.list69.name,
                toukenlist.list70.name, toukenlist.list71.name, toukenlist.list72.name, toukenlist.list73.name, toukenlist.list74.name
        )

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

            }else if(position==30){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list31.bunrui
                val touha = toukenlist.list31.touha
                val name = toukenlist.list31.name
                val nameyomi = toukenlist.list31.nameyomi
                val bikou = toukenlist.list31.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==31){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list32.bunrui
                val touha = toukenlist.list32.touha
                val name = toukenlist.list32.name
                val nameyomi = toukenlist.list32.nameyomi
                val bikou = toukenlist.list32.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==32){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list33.bunrui
                val touha = toukenlist.list33.touha
                val name = toukenlist.list33.name
                val nameyomi = toukenlist.list33.nameyomi
                val bikou = toukenlist.list33.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==33){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list34.bunrui
                val touha = toukenlist.list34.touha
                val name = toukenlist.list34.name
                val nameyomi = toukenlist.list34.nameyomi
                val bikou = toukenlist.list34.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==34){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list35.bunrui
                val touha = toukenlist.list35.touha
                val name = toukenlist.list35.name
                val nameyomi = toukenlist.list35.nameyomi
                val bikou = toukenlist.list35.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==35){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list36.bunrui
                val touha = toukenlist.list36.touha
                val name = toukenlist.list36.name
                val nameyomi = toukenlist.list36.nameyomi
                val bikou = toukenlist.list36.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==36){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list37.bunrui
                val touha = toukenlist.list37.touha
                val name = toukenlist.list37.name
                val nameyomi = toukenlist.list37.nameyomi
                val bikou = toukenlist.list37.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==37){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list38.bunrui
                val touha = toukenlist.list38.touha
                val name = toukenlist.list38.name
                val nameyomi = toukenlist.list38.nameyomi
                val bikou = toukenlist.list38.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==38){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list39.bunrui
                val touha = toukenlist.list39.touha
                val name = toukenlist.list39.name
                val nameyomi = toukenlist.list39.nameyomi
                val bikou = toukenlist.list39.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==39){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list40.bunrui
                val touha = toukenlist.list40.touha
                val name = toukenlist.list40.name
                val nameyomi = toukenlist.list40.nameyomi
                val bikou = toukenlist.list40.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==40){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list41.bunrui
                val touha = toukenlist.list41.touha
                val name = toukenlist.list41.name
                val nameyomi = toukenlist.list41.nameyomi
                val bikou = toukenlist.list41.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==41){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list42.bunrui
                val touha = toukenlist.list42.touha
                val name = toukenlist.list42.name
                val nameyomi = toukenlist.list42.nameyomi
                val bikou = toukenlist.list42.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==42){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list43.bunrui
                val touha = toukenlist.list43.touha
                val name = toukenlist.list43.name
                val nameyomi = toukenlist.list43.nameyomi
                val bikou = toukenlist.list43.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==43){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list44.bunrui
                val touha = toukenlist.list44.touha
                val name = toukenlist.list44.name
                val nameyomi = toukenlist.list44.nameyomi
                val bikou = toukenlist.list44.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==44){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list45.bunrui
                val touha = toukenlist.list45.touha
                val name = toukenlist.list45.name
                val nameyomi = toukenlist.list45.nameyomi
                val bikou = toukenlist.list45.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==45){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list46.bunrui
                val touha = toukenlist.list46.touha
                val name = toukenlist.list46.name
                val nameyomi = toukenlist.list46.nameyomi
                val bikou = toukenlist.list46.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==46){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list47.bunrui
                val touha = toukenlist.list47.touha
                val name = toukenlist.list47.name
                val nameyomi = toukenlist.list47.nameyomi
                val bikou = toukenlist.list47.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==47){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list48.bunrui
                val touha = toukenlist.list48.touha
                val name = toukenlist.list48.name
                val nameyomi = toukenlist.list48.nameyomi
                val bikou = toukenlist.list48.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==48){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list49.bunrui
                val touha = toukenlist.list49.touha
                val name = toukenlist.list49.name
                val nameyomi = toukenlist.list49.nameyomi
                val bikou = toukenlist.list49.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==49){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list50.bunrui
                val touha = toukenlist.list50.touha
                val name = toukenlist.list50.name
                val nameyomi = toukenlist.list50.nameyomi
                val bikou = toukenlist.list50.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==50){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list51.bunrui
                val touha = toukenlist.list51.touha
                val name = toukenlist.list51.name
                val nameyomi = toukenlist.list51.nameyomi
                val bikou = toukenlist.list51.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==51){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list52.bunrui
                val touha = toukenlist.list52.touha
                val name = toukenlist.list52.name
                val nameyomi = toukenlist.list52.nameyomi
                val bikou = toukenlist.list52.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==52){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list53.bunrui
                val touha = toukenlist.list53.touha
                val name = toukenlist.list53.name
                val nameyomi = toukenlist.list53.nameyomi
                val bikou = toukenlist.list53.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==53){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list54.bunrui
                val touha = toukenlist.list54.touha
                val name = toukenlist.list54.name
                val nameyomi = toukenlist.list54.nameyomi
                val bikou = toukenlist.list54.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==54){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list55.bunrui
                val touha = toukenlist.list55.touha
                val name = toukenlist.list55.name
                val nameyomi = toukenlist.list55.nameyomi
                val bikou = toukenlist.list55.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==55){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list56.bunrui
                val touha = toukenlist.list56.touha
                val name = toukenlist.list56.name
                val nameyomi = toukenlist.list56.nameyomi
                val bikou = toukenlist.list56.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==56){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list57.bunrui
                val touha = toukenlist.list57.touha
                val name = toukenlist.list57.name
                val nameyomi = toukenlist.list57.nameyomi
                val bikou = toukenlist.list57.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==57){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list58.bunrui
                val touha = toukenlist.list58.touha
                val name = toukenlist.list58.name
                val nameyomi = toukenlist.list58.nameyomi
                val bikou = toukenlist.list58.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==58){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list59.bunrui
                val touha = toukenlist.list59.touha
                val name = toukenlist.list59.name
                val nameyomi = toukenlist.list59.nameyomi
                val bikou = toukenlist.list59.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==59){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list60.bunrui
                val touha = toukenlist.list60.touha
                val name = toukenlist.list60.name
                val nameyomi = toukenlist.list60.nameyomi
                val bikou = toukenlist.list60.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==60){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list61.bunrui
                val touha = toukenlist.list61.touha
                val name = toukenlist.list61.name
                val nameyomi = toukenlist.list61.nameyomi
                val bikou = toukenlist.list61.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==61){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list62.bunrui
                val touha = toukenlist.list62.touha
                val name = toukenlist.list62.name
                val nameyomi = toukenlist.list62.nameyomi
                val bikou = toukenlist.list62.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==62){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list63.bunrui
                val touha = toukenlist.list63.touha
                val name = toukenlist.list63.name
                val nameyomi = toukenlist.list63.nameyomi
                val bikou = toukenlist.list63.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==63){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list64.bunrui
                val touha = toukenlist.list64.touha
                val name = toukenlist.list64.name
                val nameyomi = toukenlist.list64.nameyomi
                val bikou = toukenlist.list64.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==64){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list65.bunrui
                val touha = toukenlist.list65.touha
                val name = toukenlist.list65.name
                val nameyomi = toukenlist.list65.nameyomi
                val bikou = toukenlist.list65.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==65){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list66.bunrui
                val touha = toukenlist.list66.touha
                val name = toukenlist.list66.name
                val nameyomi = toukenlist.list66.nameyomi
                val bikou = toukenlist.list66.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==66){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list67.bunrui
                val touha = toukenlist.list67.touha
                val name = toukenlist.list67.name
                val nameyomi = toukenlist.list67.nameyomi
                val bikou = toukenlist.list67.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==67){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list68.bunrui
                val touha = toukenlist.list68.touha
                val name = toukenlist.list68.name
                val nameyomi = toukenlist.list68.nameyomi
                val bikou = toukenlist.list68.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==68){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list69.bunrui
                val touha = toukenlist.list69.touha
                val name = toukenlist.list69.name
                val nameyomi = toukenlist.list69.nameyomi
                val bikou = toukenlist.list69.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==69){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list70.bunrui
                val touha = toukenlist.list70.touha
                val name = toukenlist.list70.name
                val nameyomi = toukenlist.list70.nameyomi
                val bikou = toukenlist.list70.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==70){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list71.bunrui
                val touha = toukenlist.list71.touha
                val name = toukenlist.list71.name
                val nameyomi = toukenlist.list71.nameyomi
                val bikou = toukenlist.list71.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==71){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list72.bunrui
                val touha = toukenlist.list72.touha
                val name = toukenlist.list72.name
                val nameyomi = toukenlist.list72.nameyomi
                val bikou = toukenlist.list72.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==72){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list73.bunrui
                val touha = toukenlist.list73.touha
                val name = toukenlist.list73.name
                val nameyomi = toukenlist.list73.nameyomi
                val bikou = toukenlist.list73.bikou

                intent.putExtra("bunrui",bunrui)
                intent.putExtra("touha",touha)
                intent.putExtra("name",name)
                intent.putExtra("nameyomi",nameyomi)
                intent.putExtra("bikou",bikou)

                startActivity(intent)

            }else if(position==73){
                val intent = Intent(this, SecondActivity::class.java)

                val bunrui = toukenlist.list74.bunrui
                val touha = toukenlist.list74.touha
                val name = toukenlist.list74.name
                val nameyomi = toukenlist.list74.nameyomi
                val bikou = toukenlist.list74.bikou

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