package itachi_waiyan.com.padc_kotlin_first_assignment.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import itachi_waiyan.com.padc_kotlin_first_assignment.data.models.MovieModel
import itachi_waiyan.com.padc_kotlin_first_assignment.data.models.MovieModelImpl

abstract class BaseActivity : AppCompatActivity(){

    protected lateinit var model : MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = MovieModelImpl
    }
}