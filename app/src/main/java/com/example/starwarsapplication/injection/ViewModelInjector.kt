package com.think_it.starwarsappli.injection

import com.example.starwarsapplication.network.NetworkModule
import com.example.starwarsapplication.ui.theme.FilmListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(filmListViewModel: FilmListViewModel)

    @Component.Builder
    interface Builder {
        fun build() : ViewModelInjector

        fun networkModule(networkModule: NetworkModule) : Builder

    }
}