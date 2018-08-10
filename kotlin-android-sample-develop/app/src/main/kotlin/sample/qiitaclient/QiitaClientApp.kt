package sample.qiitaclient

import android.app.Application
import dagger.Component
import sample.qiitaclient.dagger.AppComponent
import sample.qiitaclient.dagger.ClientModule
import javax.inject.Singleton

open class QiitaClientApp : Application() {

    val component: AppComponent = createComponent()

    open fun createComponent(): AppComponent =
            DaggerQiitaClientApp_QiitaClientAppComponent.create()

    @Component(modules = arrayOf(ClientModule::class))
    @Singleton
    interface QiitaClientAppComponent : AppComponent
}