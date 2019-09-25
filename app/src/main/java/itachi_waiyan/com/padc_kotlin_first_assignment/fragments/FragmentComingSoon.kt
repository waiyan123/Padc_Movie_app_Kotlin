package itachi_waiyan.com.padc_kotlin_first_assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import itachi_waiyan.com.padc_kotlin_first_assignment.R

class FragmentComingSoon : Fragment {

    constructor()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coming_soon,container,false)
    }


}