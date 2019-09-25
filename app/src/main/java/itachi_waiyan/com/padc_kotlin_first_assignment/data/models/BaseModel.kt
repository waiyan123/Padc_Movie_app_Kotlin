package itachi_waiyan.com.padc_kotlin_first_assignment.data.models

import itachi_waiyan.com.padc_kotlin_first_assignment.network.dataagents.MovieAgent
import itachi_waiyan.com.padc_kotlin_first_assignment.network.dataagents.RetroAgentImpl

abstract class BaseModel {

    protected val dataAgent : MovieAgent = RetroAgentImpl

}