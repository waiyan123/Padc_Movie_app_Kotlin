package itachi_waiyan.com.padc_kotlin_first_assignment.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import itachi_waiyan.com.padc_kotlin_first_assignment.R
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import kotlinx.android.synthetic.main.movie_item_view.view.*
import org.w3c.dom.Text

class MovieDetailActivity : BaseActivity(){

    lateinit var imgClose : ImageView
    lateinit var imgMovie : ImageView
    lateinit var tvMovieTitle : TextView
    lateinit var tvMovieTime : TextView
    lateinit var tvImdb : TextView
    lateinit var tvRotten : TextView
    lateinit var tvMeta : TextView
    lateinit var tvOverview : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        imgClose = findViewById(R.id.img_close)
        imgMovie = findViewById(R.id.img_movie)
        tvMovieTitle = findViewById(R.id.tv_movie_title)
        tvMovieTime = findViewById(R.id.tv_movie_time)
        tvImdb = findViewById(R.id.tv_imdb)
        tvRotten = findViewById(R.id.tv_rotten)
        tvMeta = findViewById(R.id.tv_meta)
        tvOverview = findViewById(R.id.tv_overview)

        val movie : MovieVO = model.getMovieById(intent.getIntExtra("movieId",0))
        tvMovieTitle.text = movie.movie_name
//        tvMovieTime.text = movie.
        tvImdb.text = movie.imdb.toString()
        tvRotten.text = movie.rotten_tomato.toString()
        tvMeta.text = movie.meta_centric.toString()
        tvOverview.text = movie.overview

        Glide.with(this)
            .load(movie.poster)
            .into(imgMovie)

        imgClose.setOnClickListener {
            finish()
        }

    }

    companion object {
        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra("movieId", id)
            return intent
        }
    }
}