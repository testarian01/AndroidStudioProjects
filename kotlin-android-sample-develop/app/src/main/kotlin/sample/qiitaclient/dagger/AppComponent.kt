package sample.qiitaclient.dagger

import sample.qiitaclient.MainActivity

interface AppComponent {

    fun inject(mainActivity: MainActivity)
}