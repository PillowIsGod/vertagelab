package pillowisgod.com.vertagelab

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import pillowisgod.com.vertagelab.di.DaggerAppComponent
import javax.inject.Inject


class TestApp : Application(), HasAndroidInjector {

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent
            .builder()
            .application(application = this)
            .context(context = applicationContext)
            .build()
        appComponent.inject(this)
    }

}