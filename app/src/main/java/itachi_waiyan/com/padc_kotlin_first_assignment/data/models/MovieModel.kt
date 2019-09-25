package itachi_waiyan.com.padc_kotlin_first_assignment.data.models

import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO

interface MovieModel {

    fun getMovies(onSuccess : (List<MovieVO>)->Unit,onFailure : (String)->Unit )
}