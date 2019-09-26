package itachi_waiyan.com.padc_kotlin_first_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import itachi_waiyan.com.padc_kotlin_first_assignment.R
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import itachi_waiyan.com.padc_kotlin_first_assignment.delegates.MovieDelegate
import itachi_waiyan.com.padc_kotlin_first_assignment.viewholders.MovieItemViewHolder

class MovieRecyclerAdapter(private val delegate: MovieDelegate) :
    BaseAdapter<MovieItemViewHolder, MovieVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item_view, parent, false)
        return MovieItemViewHolder(view, delegate)
    }


}