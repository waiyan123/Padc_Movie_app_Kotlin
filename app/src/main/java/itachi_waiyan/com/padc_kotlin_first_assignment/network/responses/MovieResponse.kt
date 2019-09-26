package itachi_waiyan.com.padc_kotlin_first_assignment.network.responses

import com.google.gson.annotations.SerializedName
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import itachi_waiyan.com.padc_kotlin_first_assignment.utils.CODE_RESPONSE_OK

class MovieResponse (

    @SerializedName("code")
    val code: Int,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data : MutableList<MovieVO>
)
    {
        fun isResponseOk() : Boolean {
            return code == CODE_RESPONSE_OK && data!=null
        }
    }