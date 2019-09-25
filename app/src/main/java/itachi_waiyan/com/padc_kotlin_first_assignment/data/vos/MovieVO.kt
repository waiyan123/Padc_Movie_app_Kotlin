package itachi_waiyan.com.padc_kotlin_first_assignment.data.vos

import com.google.gson.annotations.SerializedName

data class MovieVO(

    @SerializedName ("id")
    var id : Int,

    @SerializedName ("movie_name")
    var movie_name : String,

    @SerializedName ("imdb")
    var rating : Int,

    @SerializedName ("rotten_tomato")
    var rotten_tomato : Int,

    @SerializedName ("meta_centric")
    var meta_centric : Int ,

    @SerializedName ("genre")
    var genreList : ArrayList<GenreVO>,

    @SerializedName ("overview")
    var overview : String ,

    @SerializedName ("poster")
    var poster : String


)

{
}