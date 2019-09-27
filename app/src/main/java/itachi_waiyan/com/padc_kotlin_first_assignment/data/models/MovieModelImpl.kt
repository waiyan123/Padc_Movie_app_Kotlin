package itachi_waiyan.com.padc_kotlin_first_assignment.data.models

import android.util.Log
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import itachi_waiyan.com.padc_kotlin_first_assignment.utils.DUMMY_ACCESS_TOKEN
import itachi_waiyan.com.padc_kotlin_first_assignment.utils.PARAM_ACCESS_TOKEN

object MovieModelImpl : BaseModel(),MovieModel{

    override fun getMovies(accessToken: String,onSuccess: (MutableList<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        val moviesFromDb = database.movieDao().getAllMovies()
        if(moviesFromDb.isNotEmpty()){
            onSuccess(moviesFromDb)
        }
        else {
            dataAgent.getMovies(
                DUMMY_ACCESS_TOKEN,
                {
                    database.movieDao().insertMovies(it)
                },
                onFailure
            )
        }
        dataAgent.getMovies(
            DUMMY_ACCESS_TOKEN,
            onSuccess,
            onFailure
        )
    }


}