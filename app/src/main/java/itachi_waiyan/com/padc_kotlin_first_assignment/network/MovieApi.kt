package itachi_waiyan.com.padc_kotlin_first_assignment.network

import itachi_waiyan.com.padc_kotlin_first_assignment.network.responses.MovieResponse
import itachi_waiyan.com.padc_kotlin_first_assignment.utils.GET_MOVIES
import itachi_waiyan.com.padc_kotlin_first_assignment.utils.PARAM_ACCESS_TOKEN
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MovieApi {

    @POST (GET_MOVIES)
    @FormUrlEncoded
    fun getMovies(@Field(PARAM_ACCESS_TOKEN)accessToken : String) : Call<MovieResponse>
}