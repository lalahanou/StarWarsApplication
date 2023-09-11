package com.example.starwarsapplication.base

import androidx.lifecycle.ViewModel
import com.example.starwarsapplication.network.NetworkModule
import com.example.starwarsapplication.ui.theme.FilmListViewModel
import com.think_it.starwarsappli.injection.ViewModelInjector


abstract class BaseViewModel : ViewModel() {

    private val injector : ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject (){
        when (this) {
            is FilmListViewModel -> injector.inject(this)
        }
    }
}