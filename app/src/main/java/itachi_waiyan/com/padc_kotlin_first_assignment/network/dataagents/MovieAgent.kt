package itachi_waiyan.com.padc_kotlin_first_assignment.network.dataagents

import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO

interface MovieAgent {

fun getMovies(onSuccess : (List<MovieVO>)-> Unit , onFailure : (String)->Unit)
}