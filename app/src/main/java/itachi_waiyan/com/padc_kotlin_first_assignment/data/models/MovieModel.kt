package itachi_waiyan.com.padc_kotlin_first_assignment.data.models

import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO

interface MovieModel {

    fun getMovies(accessToken: String,onSuccess : (MutableList<MovieVO>)->Unit,onFailure : (String)->Unit )
}