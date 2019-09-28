package itachi_waiyan.com.padc_kotlin_first_assignment.viewholders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.GenreVO
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import itachi_waiyan.com.padc_kotlin_first_assignment.delegates.MovieDelegate
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.movie_item_view.view.*

class MovieItemViewHolder(itemView:View,private val delegate:MovieDelegate) : BaseViewHolder<MovieVO>(itemView){

    lateinit var list : List<GenreVO>
    init {
        itemView.setOnClickListener {
            val id = data?.id
            if(id!=null) delegate.onTabMovieItem(id)
        }
    }

    override fun bindData(data: MovieVO) {
        itemView.setOnClickListener {
            val id = data?.id
            if(id!=null) delegate.onTabMovieItem(id)
        }
        itemView.tv_movie_title.text = data.movie_name

//        list = data.genreList
//        itemView.tv_movie_time.text = list.get(0).name
        itemView.tv_imdb.text = data.imdb.toString()
        itemView.tv_rotten.text = data.rotten_tomato.toString()+"%"
        itemView.tv_meta.text = data.meta_centric.toString()+"%"

        Glide.with(itemView)
            .load(data.poster)
            .into(itemView.img_movie)

    }


}