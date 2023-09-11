package com.example.starwarsapplication.ui.theme

import androidx.lifecycle.MutableLiveData
import com.example.starwarsapplication.base.BaseViewModel
import com.example.starwarsapplication.model.Post

class PostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post){
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody():MutableLiveData<String>{
        return postBody
    }
}