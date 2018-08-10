package sample.qiitaclient.dagger

import dagger.Module
import dagger.Provides
import org.mockito.Mockito
import sample.qiitaclient.client.ArticleClient
import javax.inject.Singleton

@Module
class MockClientModule {

    @Provides
    @Singleton
    fun provideArticleClient(): ArticleClient =
            Mockito.mock(ArticleClient::class.java)
}