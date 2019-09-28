package itachi_waiyan.com.padc_kotlin_first_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import itachi_waiyan.com.padc_kotlin_first_assignment.activities.BaseActivity
import itachi_waiyan.com.padc_kotlin_first_assignment.activities.MovieDetailActivity
import itachi_waiyan.com.padc_kotlin_first_assignment.adapters.MainViewPagerAdapter
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import itachi_waiyan.com.padc_kotlin_first_assignment.delegates.MovieDelegate
import itachi_waiyan.com.padc_kotlin_first_assignment.fragments.FragmentCinema
import itachi_waiyan.com.padc_kotlin_first_assignment.fragments.FragmentComingSoon
import itachi_waiyan.com.padc_kotlin_first_assignment.fragments.FragmentNowShowing

class MainActivity : BaseActivity(),MovieDelegate {

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

    override fun onTabMovieItem(movieId: Int) {
        startActivity(
            MovieDetailActivity.newIntent(
                this,
                movieId
            )
        )
    }
}
