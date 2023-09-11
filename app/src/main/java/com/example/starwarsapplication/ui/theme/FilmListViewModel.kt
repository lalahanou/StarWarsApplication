package com.example.starwarsapplication.ui.theme

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.starwarsapplication.R
import com.example.starwarsapplication.base.BaseViewModel
import com.example.starwarsapplication.model.Post
import com.example.starwarsapplication.network.StarWarsApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class FilmListViewModel : BaseViewModel() {
    @Inject
    lateinit var starWarsApi: StarWarsApi

    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val filmListAdapter : FilmListAdapter = FilmListAdapter()
    val errorClickListenner = View.OnClickListener { loadFilms()
    }

    init {
        loadFilms()
    }

    private fun loadFilms() {

        subscription = starWarsApi.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveFilmListStart() }
            .doOnTerminate { onRetrieveFilmListFinish() }
            .subscribe(
                { result -> onRetrieveFilmListSuccess(result) },
                { onRetrieveFilmListError() }
            )
    }

    private fun onRetrieveFilmListError() {
        errorMessage.value = R.string.post_error
        Log.d("tts", "onRetrieveFilmListError")

    }

    private fun onRetrieveFilmListSuccess(filmList: List<Post>) {
        filmListAdapter.updateFilmList(filmList)
       Log.d("tts", "onRetrieveFilmListSuccess "+filmList.get(0))
    }

    private fun onRetrieveFilmListFinish() {
        loadingVisibility.value = View.GONE
        Log.d("tts", "onRetrieveFilmListFinish")

    }

    private fun onRetrieveFilmListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
        Log.d("tts", "onRetrieveFilmListStart")

    }

    private fun onRetreiveFilmListError()
    {
        errorMessage.value = R.string.post_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}