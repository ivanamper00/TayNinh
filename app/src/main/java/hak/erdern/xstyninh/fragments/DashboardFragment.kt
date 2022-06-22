package hak.erdern.xstyninh.fragments

import hak.erdern.xstyninh.R
import hak.erdern.xstyninh.base.BaseFragment
import hak.erdern.xstyninh.binding.viewBinding
import hak.erdern.xstyninh.databinding.FragmentMainBinding

class DashboardFragment(
    private val listener: Listener
): BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    override fun setupViews() {
        with(binding){

            home.setOnClickListener { listener.onBottomNavSelectedId(R.id.home) }
            about.setOnClickListener { listener.onBottomNavSelectedId(R.id.about) }
            tips.setOnClickListener { listener.onBottomNavSelectedId(R.id.tips) }
            settings.setOnClickListener { listener.onBottomNavSelectedId(R.id.money) }
            button1.setOnClickListener { listener.onBottomNavSelectedId(R.id.button1) }
            button2.setOnClickListener { listener.onBottomNavSelectedId(R.id.button2) }
        }
    }

    override fun viewModelObservers() {
    }

    interface Listener{
        fun onBottomNavSelectedId(id: Int)
    }

}