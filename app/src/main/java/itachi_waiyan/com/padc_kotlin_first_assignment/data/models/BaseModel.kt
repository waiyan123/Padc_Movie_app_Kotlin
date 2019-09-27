package itachi_waiyan.com.padc_kotlin_first_assignment.data.models

import android.content.Context
import itachi_waiyan.com.padc_kotlin_first_assignment.network.dataagents.MovieAgent
import itachi_waiyan.com.padc_kotlin_first_assignment.network.dataagents.RetroAgentImpl
import itachi_waiyan.com.padc_kotlin_first_assignment.persistence.MyDatabase

abstract class BaseModel {

    protected val dataAgent : MovieAgent = RetroAgentImpl

    protected lateinit var database : MyDatabase

    fun initDatabase(context:Context){
        database = MyDatabase.getInstance(context)
    }

}