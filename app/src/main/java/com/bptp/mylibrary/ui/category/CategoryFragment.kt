package com.bptp.mylibrary.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bptp.mylibrary.ViewPagerAdapter
import com.bptp.mylibrary.databinding.FragmentCategoryBinding
import com.bptp.mylibrary.ui.category.general.GeneralFragment
import com.google.android.material.tabs.TabLayoutMediator

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        //adding fragment to adapter
        viewPagerAdapter.addFragment(GeneralFragment.newInstance(), "Umum")
        viewPagerAdapter.addFragment(GeneralFragment.newInstance(), "Filsafat")
        viewPagerAdapter.addFragment(GeneralFragment.newInstance(), "Ilmu Pengetahuan Masyarakat")
        viewPagerAdapter.addFragment(GeneralFragment.newInstance(), "Bahasa")
        viewPagerAdapter.addFragment(GeneralFragment.newInstance(), "Matematika")
        viewPagerAdapter.addFragment(GeneralFragment.newInstance(), "Ilmu Pengetahuan Terapan")
        viewPagerAdapter.addFragment(GeneralFragment.newInstance(), "Kesenian")
        viewPagerAdapter.addFragment(GeneralFragment.newInstance(), "Literatur")
        viewPagerAdapter.addFragment(GeneralFragment.newInstance(), "Sejarah")
        binding.vpTask.adapter = viewPagerAdapter
        //setting title for tab layout
        TabLayoutMediator(binding.tlTask, binding.vpTask, true) { tab, pos ->
            tab.text = viewPagerAdapter.getPageTitle(pos)
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}