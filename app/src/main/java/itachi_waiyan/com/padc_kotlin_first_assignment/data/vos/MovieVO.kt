package itachi_waiyan.com.padc_kotlin_first_assignment.data.vos

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies_table")
data class MovieVO(

    @PrimaryKey
    @SerializedName ("id")
    @ColumnInfo(name = "id")
    var id : Int,

    @SerializedName ("movie_name")
    @ColumnInfo(name = "movie_name")
    var movie_name : String,

    @SerializedName ("imdb")
    @ColumnInfo(name = "imdb")
    var imdb : Double,

    @SerializedName ("rotten_tomato")
    @ColumnInfo(name="rotten_tomato")
    var rotten_tomato : Int,

    @SerializedName ("meta_centric")
    @ColumnInfo(name="meta_centric")
    var meta_centric : Int ,

    @SerializedName ("genre")
    @ColumnInfo(name = "genre")
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