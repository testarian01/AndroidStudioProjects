package sample.qiitaclient.client

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable
import tk.httpcarabineer.qiitaclient.Article

interface ArticleClient {

    @GET("/api/v2/items")
    fun search(@Query("query") query: String): Observable<List<Article>>
}