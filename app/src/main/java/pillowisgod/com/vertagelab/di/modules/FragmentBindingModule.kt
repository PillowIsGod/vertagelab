package pillowisgod.com.vertagelab.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pillowisgod.com.vertagelab.screens.LoginFragment
import pillowisgod.com.vertagelab.screens.MapFragment


@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun loginFragment() : LoginFragment
    @ContributesAndroidInjector
    abstract fun mapFragment() : MapFragment

}