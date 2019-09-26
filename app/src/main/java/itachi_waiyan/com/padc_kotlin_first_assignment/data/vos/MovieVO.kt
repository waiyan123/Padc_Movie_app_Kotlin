package itachi_waiyan.com.padc_kotlin_first_assignment.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class MovieVO(

    @SerializedName ("id")
    @ColumnInfo(name = "id")
    var id : Int,

    @SerializedName ("movie_name")
    @ColumnInfo(name = "movie_name")
    var movie_name : String,

    @SerializedName ("imdb")
    @ColumnInfo(name = "imdb")
    var rating : Int,

    @SerializedName ("rotten_tomato")
    @ColumnInfo(name="rotten_tomato")
    var rotten_tomato : Int,

    @SerializedName ("meta_centric")
    @ColumnInfo(name="meta_centric")
    var meta_centric : Int ,

    @SerializedName ("genre")
    @Embedded(prefix="genre")
    var genreList : List<GenreVO>,

    @SerializedName ("overview")
    @ColumnInfo(name="overview")
    var overview : String ,

    @SerializedName ("poster")
    @ColumnInfo(name="poster")
    var poster : String




)

{
}