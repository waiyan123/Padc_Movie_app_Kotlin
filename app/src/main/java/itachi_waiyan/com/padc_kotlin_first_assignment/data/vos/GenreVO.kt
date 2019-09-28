package itachi_waiyan.com.padc_kotlin_first_assignment.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class GenreVO(

    @SerializedName ("id")
    @ColumnInfo(name = "id")
    var id : Int,

    @SerializedName ("name")
    @ColumnInfo(name = "name")
    var name : String
)