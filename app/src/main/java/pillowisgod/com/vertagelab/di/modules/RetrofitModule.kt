package pillowisgod.com.vertagelab.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pillowisgod.com.vertagelab.data.repository.apicalls.TestApiCall
import pillowisgod.com.vertagelab.di.AppScope
import pillowisgod.com.vertagelab.helpers.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class RetrofitModule {
    @AppScope
    @Provides
    fun provideClient(): OkHttpClient {
        return OkHttpClient
                .Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
    }

    @AppScope
    @Provides
    fun provideTestRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @AppScope
    @Provides
    fun provideTestApi(retrofit: Retrofit): TestApiCall {
        return retrofit.create(TestApiCall::class.java)
    }

}