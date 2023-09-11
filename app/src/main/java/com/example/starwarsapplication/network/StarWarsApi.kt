package com.example.starwarsapplication.network

import com.example.starwarsapplication.model.Film
import com.example.starwarsapplication.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface StarWarsApi {

    /**
     * Get the list of the films from the API
     */

    @GET("films/")
    fun getFilms(): Observable<List<Film>>

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>

}