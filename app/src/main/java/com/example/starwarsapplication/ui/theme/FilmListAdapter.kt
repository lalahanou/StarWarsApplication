package com.example.starwarsapplication.ui.theme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapplication.R
import com.example.starwarsapplication.databinding.ItemPostBinding
import com.example.starwarsapplication.model.Film
import com.example.starwarsapplication.model.Post

class FilmListAdapter : RecyclerView.Adapter<FilmListAdapter.ViewHolder>() {

    private lateinit var filmList: List<Film>
    private lateinit var postList: List<Post>

    override fun getItemCount(): Int {

            //return if(::filmList.isInitialized) filmList.size else 0
            return if(::postList.isInitialized) postList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       // holder.bind(filmList[position])
        holder.bind(postList[position])
    }


    fun updateFilmList( filmList: List<Post>){
        this.postList = filmList
        //this.filmList = filmList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemPostBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_post, parent, false)
        return ViewHolder(binding)
    }


    class ViewHolder(private val binding: ItemPostBinding):RecyclerView.ViewHolder(binding.root) {

        private val viewModel = PostViewModel()
//        fun bind(film : Film){
//            viewModel.bind(film)
//            binding.viewModel = viewModel
//        }


        fun bind(post : Post){
            viewModel.bind(post)
            binding.viewModel = viewModel
        }

    }
}