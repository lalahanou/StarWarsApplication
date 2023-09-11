package com.example.starwarsapplication.network

import com.example.starwarsapplication.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
// Safe here as we are dealing with a Dagger 2 module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideFilmApi(retrofit: Retrofit) : StarWarsApi {
        return  retrofit.create(StarWarsApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun providerRetrofitInterface() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}