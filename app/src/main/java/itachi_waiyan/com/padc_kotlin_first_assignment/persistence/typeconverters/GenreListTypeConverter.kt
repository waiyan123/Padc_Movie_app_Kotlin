package itachi_waiyan.com.padc_kotlin_first_assignment.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO

class GenreListTypeConverter {

    @TypeConverter
    fun toString(list:MutableList<MovieVO>):String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(json:String):MutableList<MovieVO>{
        val typeToken = object : TypeToken<MutableList<MovieVO>>(){

        }.type
        return Gson().fromJson(json,typeToken)
    }
}