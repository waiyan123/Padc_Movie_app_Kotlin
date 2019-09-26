package itachi_waiyan.com.padc_kotlin_first_assignment.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import itachi_waiyan.com.padc_kotlin_first_assignment.R
import itachi_waiyan.com.padc_kotlin_first_assignment.adapters.MovieRecyclerAdapter
import itachi_waiyan.com.padc_kotlin_first_assignment.data.models.MovieModelImpl
import itachi_waiyan.com.padc_kotlin_first_assignment.delegates.MovieDelegate

class FragmentNowShowing : Fragment(){

    lateinit var recyclerView : RecyclerView
    lateinit var adapter : MovieRecyclerAdapter
    lateinit var delegate : MovieDelegate

    lateinit var model : MovieModelImpl

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView : View = inflater.inflate(R.layout.fragment_now_showing,container,false)
        recyclerView = itemView.findViewById(R.id.rv_movie)
        adapter = MovieRecyclerAdapter(delegate)
        model = MovieModelImpl
        return itemView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.getMovies("",{
            adapter.setNewData(it)
        },{

        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate = context as MovieDelegate
    }


}