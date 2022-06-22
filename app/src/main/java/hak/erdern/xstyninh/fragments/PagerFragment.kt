package hak.erdern.xstyninh.fragments

import androidx.core.text.HtmlCompat
import hak.erdern.xstyninh.R
import hak.erdern.xstyninh.base.BaseFragment
import hak.erdern.xstyninh.binding.viewBinding
import hak.erdern.xstyninh.databinding.FragmentPagerBinding

class PagerFragment(
    private val content: DataModel
): BaseFragment<FragmentPagerBinding>(R.layout.fragment_pager) {

    override val binding: FragmentPagerBinding by viewBinding(FragmentPagerBinding::bind)

    override fun setupViews() {
        with(binding){
            contentDesc.text = content.desc
            contentTitle.text = content.title
            banner.setBackgroundResource(content.image)
        }
    }

    override fun viewModelObservers() {
    }

}