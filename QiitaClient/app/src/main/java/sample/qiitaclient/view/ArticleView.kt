package sample.qiitaclient.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import tk.httpcarabineer.qiitaclient.Article
import tk.httpcarabineer.qiitaclient.R
//import tk.httpcarabineer.qiitaclient.model.Article

class ArticleView : FrameLayout {
    constructor(context: Context?) : super(context)

    constructor(context: Context?,
                attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int,
                defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    val profileImageView:ImageView by lazy{
        findViewById(R.id.profile_image_view) as ImageView
    }

    val titleTextView: TextView by lazy {
        findViewById(R.id.title_text_view) as TextView
    }

    val usernameTextView: TextView by lazy {
        findViewById(R.id.user_name_text_view) as TextView
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_article, this)
//        profileImageView = findViewById(R.id.profile_image_view) as ImageView
//        titleTextView = findViewById(R.id.title_text_view) as TextView
//        usernameTextView = findViewById(R.id.user_name_text_view) as TextView
    }

    fun setArticle(article: Article){
        titleTextView.text = article.title
        usernameTextView.text = article.user.name

        //TODOプロフィール画像をセットする
        profileImageView.setBackgroundColor(Color.RED)
    }

}