package com.example.starwarsapplication.ui.theme

import androidx.lifecycle.MutableLiveData
import com.example.starwarsapplication.base.BaseViewModel
import com.example.starwarsapplication.model.Film

class FilmViewModel : BaseViewModel(){

    private val filmCount = MutableLiveData<Int>()


    fun bind(film : Film){
        filmCount.value = film.count
    }

    fun filmCount():MutableLiveData<Int>{
        return filmCount
    }
}