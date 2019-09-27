package itachi_waiyan.com.padc_kotlin_first_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.widget.ImageViewCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import itachi_waiyan.com.padc_kotlin_first_assignment.activities.BaseActivity
import itachi_waiyan.com.padc_kotlin_first_assignment.adapters.MainViewPagerAdapter
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import itachi_waiyan.com.padc_kotlin_first_assignment.delegates.MovieDelegate
import itachi_waiyan.com.padc_kotlin_first_assignment.fragments.FragmentCinema
import itachi_waiyan.com.padc_kotlin_first_assignment.fragments.FragmentComingSoon
import itachi_waiyan.com.padc_kotlin_first_assignment.fragments.FragmentNowShowing
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MovieDelegate {

    override fun onTabMovieItem(movieId: Int) {
        Toast.makeText(this,"Clicked",Toast.LENGTH_LONG).show()
    }

    lateinit var textView: TextView
    lateinit var imgSearch : ImageView
    private var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    lateinit var movieList : MutableList<MovieVO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv_title)
        imgSearch = findViewById(R.id.img_search)

        tabLayout = findViewById(R.id.main_tab_layout)as TabLayout
        viewPager = findViewById(R.id.main_view_pager)as ViewPager

        model.getMovies("",
            {
            movieList = it

                Toast.makeText(this,movieList.get(0).movie_name,Toast.LENGTH_SHORT).show()
                tabLayout!!.setupWithViewPager(viewPager)
                setUpWithViewPager(viewPager!!)
        },
            {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        })

    }

    fun setUpWithViewPager(viewPager: ViewPager){
        val adapter = MainViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentNowShowing(movieList), "ONE")
        adapter.addFragment(FragmentCinema(), "TWO")
        adapter.addFragment(FragmentComingSoon(), "THREE")
        viewPager.adapter = adapter
    }
}
