package pillowisgod.com.vertagelab.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import pillowisgod.com.vertagelab.TestApp
import pillowisgod.com.vertagelab.di.modules.ActivityBindingModule
import pillowisgod.com.vertagelab.di.modules.FragmentBindingModule
import pillowisgod.com.vertagelab.di.modules.RetrofitModule
import pillowisgod.com.vertagelab.di.modules.RoomModule


@Component(modules = [RoomModule::class,
RetrofitModule::class,
ActivityBindingModule::class,
FragmentBindingModule::class,
AndroidInjectionModule::class])
@AppScope
interface AppComponent : AndroidInjector<TestApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application : Application) : AppComponent.Builder
        @BindsInstance
        fun context(context: Context) : AppComponent.Builder
        fun build() : AppComponent
    }
}