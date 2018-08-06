//P262まで

package tk.httpcarabineer.qiitaclient

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DialogTitle
import android.webkit.WebView
import android.widget.ListView
import sample.qiitaclient.view.ArticleActivity
import sample.qiitaclient.view.ArticleListAdapter
import sample.qiitaclient.view.ArticleView
import tk.httpcarabineer.qiitaclient.Article
import tk.httpcarabineer.qiitaclient.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.view_article)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listAdapter = ArticleListAdapter(applicationContext)
        listAdapter.articles = listOf(dummyArticle("テスト", "たろうさん"),
                dummyArticle("テスト", "じろうさん"))

        val listView: ListView = findViewById(R.id.list_view) as ListView
        listView.adapter = listAdapter
        listView.setOnItemClickListener { adapterView, view, position, id ->
            val article = listAdapter.articles[position]
            ArticleActivity.intent(this, article).let { startActivity(it) }
        }
    }

    //ダミー記事を生成するメソッド
    private fun dummyArticle(title: String, userName: String): Article =
            Article(id = "",
                    title = title,
                    url = "https://kotlinlang.org/",
                    user = User(id = "", name = userName, profileImageUrl = ""))
}

