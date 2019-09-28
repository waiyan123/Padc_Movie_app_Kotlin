package itachi_waiyan.com.padc_kotlin_first_assignment.data.models

import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import itachi_waiyan.com.padc_kotlin_first_assignment.utils.DUMMY_ACCESS_TOKEN

object MovieModelImpl : BaseModel(),MovieModel{
    override fun getMovieById(id: Int): MovieVO {
        return database.movieDao().getMovieById(id)
    }

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