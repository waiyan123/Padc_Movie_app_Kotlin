package itachi_waiyan.com.padc_kotlin_first_assignment.data.models

import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO

object MovieModelImpl : BaseModel(),MovieModel{

    override fun getMovies(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        dataAgent.getMovies({
            onSuccess(it)
        },
            {
                onFailure(it)
            })
    }


}