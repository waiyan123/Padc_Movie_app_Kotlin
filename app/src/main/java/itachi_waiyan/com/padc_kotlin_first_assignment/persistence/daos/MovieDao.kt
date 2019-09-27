package itachi_waiyan.com.padc_kotlin_first_assignment.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO

@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movies:MutableList<MovieVO>) : LongArray

    @Query("select * from movies_table")
    abstract fun getAllMovies():MutableList<MovieVO>

    @Query("select * from movies_table where id=:id")
    abstract fun getMovieById(id:Int): MovieVO

    fun MoviesInDbExist():Boolean {
        return getAllMovies().isNotEmpty()
    }

}