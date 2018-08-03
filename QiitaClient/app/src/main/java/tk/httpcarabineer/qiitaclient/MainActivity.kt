//P254まで

package tk.httpcarabineer.qiitaclient

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DialogTitle
import android.widget.ListView
import sample.qiitaclient.view.ArticleListAdapter
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
    }

    //ダミー記事を生成するメソッド
    private fun dummyArticle(title: String, userName: String): Article =
            Article(id = "",
                    title = title,
                    url = "https://kotlinlang.org/",
                    user = User(id = "", name = userName, profileImageUrl = ""))

//        //ArticleViewオブジェクトを生成
//        val articleView = ArticleView(applicationContext)
//
//        //Articleオブジェクトを生成して、ArticleViewオブジェクトにセット
//        articleView.setArticle(Article(id="123",
//                title = "Kotlin入門",
//                url = "http://www.example.com/articles/123",
//                user = User(id="456",name="たろう",profileImageUrl = "")))
//
//        //このアクテビティにArticleViewオブジェクトをセット
//        setContentView(articleView)

}

//package tk.httpcarabineer.qiitaclient
//
//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import sample.qiitaclient.view.ArticleView
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.view_article)
//        super.onCreate(savedInstanceState)
//
//        //ArticleViewオブジェクトを生成
//        val articleView = ArticleView(applicationContext)
//
//        //Articleオブジェクトを生成して、ArticleViewオブジェクトにセット
//        articleView.setArticle(Article(id="123",
//                title = "Kotlin入門",
//                url = "http://www.example.com/articles/123",
//                user = User(id="456",name="たろう",profileImageUrl = "")))
//
//        //このアクテビティにArticleViewオブジェクトをセット
//        setContentView(articleView)
//    }
//}

