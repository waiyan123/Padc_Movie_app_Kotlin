package itachi_waiyan.com.padc_kotlin_first_assignment.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import itachi_waiyan.com.padc_kotlin_first_assignment.persistence.daos.MovieDao
import itachi_waiyan.com.padc_kotlin_first_assignment.persistence.typeconverters.GenreListTypeConverter

@Database(entities = arrayOf(MovieVO::class),version = 1,exportSchema = false)
@TypeConverters(GenreListTypeConverter::class)
abstract class MyDatabase : RoomDatabase(){
    abstract fun movieDao() : MovieDao

    companion object{
        private var instance : MyDatabase?=null
        fun getInstance(context:Context):MyDatabase{
            if(instance==null){
                instance = Room.databaseBuilder(context,MyDatabase::class.java,"MyDatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            val db = instance!!
            return db
        }
    }
}