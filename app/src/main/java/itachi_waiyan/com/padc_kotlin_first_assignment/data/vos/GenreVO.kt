package itachi_waiyan.com.padc_kotlin_first_assignment.data.vos

import com.google.gson.annotations.SerializedName

data class GenreVO(

    @SerializedName ("id")
    var id : Int,

    @SerializedName ("name")
    var name : String
)