package itachi_waiyan.com.padc_kotlin_first_assignment

import android.app.Application
import itachi_waiyan.com.padc_kotlin_first_assignment.data.models.MovieModelImpl

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDatabase(applicationContext)
    }

}