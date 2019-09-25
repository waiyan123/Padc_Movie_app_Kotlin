package itachi_waiyan.com.padc_kotlin_first_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.ImageViewCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.tabs.TabLayout
import itachi_waiyan.com.padc_kotlin_first_assignment.activities.BaseActivity
import itachi_waiyan.com.padc_kotlin_first_assignment.adapters.MainViewPagerAdapter
import itachi_waiyan.com.padc_kotlin_first_assignment.data.vos.MovieVO
import itachi_waiyan.com.padc_kotlin_first_assignment.fragments.FragmentCinema
import itachi_waiyan.com.padc_kotlin_first_assignment.fragments.FragmentComingSoon
import itachi_waiyan.com.padc_kotlin_first_assignment.fragments.FragmentNowShowing

class MainActivity : BaseActivity() {

    @BindView(R.id.navigation)
    lateinit var toolbar: ImageViewCompat

    @BindView(R.id.textView)
    lateinit var textView : TextView

    @BindView(R.id.img_search)
    lateinit var imgSearch : ImageViewCompat

    @BindView(R.id.main_tab_layout)
    lateinit var mainTab : TabLayout

    @BindView(R.id.main_view_pager)
    lateinit var mainViewPager : ViewPager2

    lateinit var movieList : List<MovieVO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        model.getMovies({
            movieList = it
        },
            {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        })

    }

    fun setUpWithViewPager(viewPager: ViewPager){
        val adapter = MainViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentNowShowing(), "ONE")
        adapter.addFragment(FragmentCinema(), "TWO")
        adapter.addFragment(FragmentComingSoon(), "THREE")
        viewPager.adapter = adapter
    }
}
