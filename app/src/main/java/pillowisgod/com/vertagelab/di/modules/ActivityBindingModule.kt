package pillowisgod.com.vertagelab.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pillowisgod.com.vertagelab.MainActivity

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun mainActivity() : MainActivity
}