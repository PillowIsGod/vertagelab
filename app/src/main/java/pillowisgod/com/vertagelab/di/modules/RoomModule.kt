package pillowisgod.com.vertagelab.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import pillowisgod.com.vertagelab.data.database.LoginDAO
import pillowisgod.com.vertagelab.data.database.LoginDatabase
import pillowisgod.com.vertagelab.di.AppScope
import pillowisgod.com.vertagelab.helpers.Constants.DATABASE_NAME

@Module
class RoomModule {
    @AppScope
    @Provides
    fun providesDatabase(context : Context) : LoginDatabase {
        return Room.databaseBuilder(
            context,
            LoginDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @AppScope
    @Provides
    fun provideLoginDao(loginDatabase: LoginDatabase) : LoginDAO {
        return loginDatabase.loginDao()
    }

}