package itachi_waiyan.com.padc_kotlin_first_assignment.network.dataagents

import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import itachi_waiyan.com.padc_kotlin_first_assignment.network.MovieApi
import itachi_waiyan.com.padc_kotlin_first_assignment.network.responses.MovieResponse
import itachi_waiyan.com.padc_kotlin_first_assignment.utils.BASE_URL
import itachi_waiyan.com.padc_kotlin_first_assignment.utils.EM_NULL_EVENT_RESPONSE
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetroAgentImpl : MovieAgent {

    private val movieApi : MovieApi

    init {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retroFit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieApi = retroFit.create(MovieApi::class.java)


    }

    override fun getMovies(accessToken : String,onSuccess: (MutableList<MovieVO>) -> Unit, onFailure: (String) -> Unit) {

        val call = movieApi.getMovies(accessToken)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                val mResponse = response.body()
                if(mResponse!=null){
                    if(mResponse.data != null){
                        onSuccess(mResponse.data)
                    }
                    else onFailure(mResponse.message)
                }
                else {
                    onFailure(EM_NULL_EVENT_RESPONSE)
                }
            }

        })
    }


}