package hak.erdern.xstyninh

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import hak.erdern.xstyninh.binding.viewBinding
import hak.erdern.xstyninh.databinding.ActivityMainBinding
import hak.erdern.xstyninh.fragments.DashboardFragment
import hak.erdern.xstyninh.fragments.Data
import hak.erdern.xstyninh.fragments.PagerFragment

class MainActivity : AppCompatActivity(),
    DashboardFragment.Listener {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    lateinit var fragments: List<Fragment>

    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {

        fragments = listOf(
             DashboardFragment(this),
            PagerFragment(Data.items[0]),
            PagerFragment(Data.items[1]),
            PagerFragment(Data.items[2]),
            PagerFragment(Data.items[3]),
            PagerFragment(Data.items[4]),
            PagerFragment(Data.items[5]),
        )

        viewPagerAdapter = ViewPagerAdapter(this, fragments)

        with(binding){


            with(viewPager){
                adapter = viewPagerAdapter
                offscreenPageLimit = 6
            }

            with(bottomNavigationView){
                setOnItemSelectedListener { item ->
                    when(item.itemId){
                        R.id.home -> setCurrentItem(0)
                        R.id.money -> setCurrentItem(1)
                        R.id.about -> setCurrentItem(2)
                        R.id.tips -> setCurrentItem(3)
                        R.id.file -> setCurrentItem(4)
                        else -> {}
                    }
                    true
                }
            }
        }
    }

    private fun setCurrentItem(i: Int) {
        binding.viewPager.setCurrentItem(i, false)
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onBottomNavSelectedId(id: Int) {
        when(id){
            R.id.button1 -> setCurrentItem(5)
            R.id.button2 -> setCurrentItem(6)
            else -> binding.bottomNavigationView.selectedItemId = id
        }
    }
}